package tsunagi.example.processModel.node.groupPR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import tsunagi.core.Lang;
import tsunagi.core.SystemException;
import tsunagi.core.db.DatabaseManager;
import tsunagi.core.db.sql.SqlExecWrapper;

public class TrackInfo {
	public static final String ID_START_TIME = "startTime";
	public static final String ID_NUMB_OF_MEMEBERS = "numberOfMemebers";
	public static final String ID_NUMB_OF_RESPONSES = "numberOfResponses";
	public static final String ID_LIST_UNFINISHED_USERS = "listUnfinishedUsers";
	public static final String ID_END_TIME = "endTime";
	
	private String processInstanceId;
	private String processInstanceName;
	
	public TrackInfo(){
		super();
	}
	public TrackInfo(String processInstanceId) {
		super();
		this.setProcessInstanceId(processInstanceId);
	}
	public String getProcessInstanceName() {
		return processInstanceName;
	}
	public void setProcessInstanceName(String processInstanceName) {
		this.processInstanceName = processInstanceName;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getInfo(Connection conn, String infoId) {
		StringBuffer result = new StringBuffer();
		try {
			if (ID_START_TIME.equals(infoId)) this.addStartTime(conn, result);
			if (ID_NUMB_OF_MEMEBERS.equals(infoId)) this.addNumberOfMembers(conn, result);
			if (ID_NUMB_OF_RESPONSES.equals(infoId)) this.addNumberOfResponses(conn, result);
			if (ID_LIST_UNFINISHED_USERS.equals(infoId)) this.addListUnfinishedUsers(conn, result);
			if (ID_END_TIME.equals(infoId)) this.addEndTime(conn, result);
		}
		catch(Exception e) {
			throw new SystemException(e);
		}
		return result.toString();
	}
	protected void addStartTime(Connection conn, StringBuffer result) throws Exception {
		ResultSet rs = null;
		PreparedStatement  s = conn.prepareStatement("select STRT_TM from OJB_NODE_LOG where PREV_ND_LOG_ID is null and PROC_INST_ID=?");
		s.setString(1, this.getProcessInstanceId());
		rs = SqlExecWrapper.INSTANCE.executeQuery(s);
		
		if (rs.next()) {
			result.append(rs.getTimestamp(1));
		}
		
		rs.close();
		s.close();
	}
	protected void addNumberOfMembers(Connection conn, StringBuffer result) throws Exception {
		ResultSet rs = null;
		PreparedStatement  s = conn.prepareStatement("select count(*) from ojb_task where META_TASK_ID in (select ID from ojb_meta_task where PROC_INST_ID=? and ND_NM='" + this.getProcessInstanceName() + ".GroupPRMemberRequest')");
		s.setString(1, this.getProcessInstanceId());
		rs = SqlExecWrapper.INSTANCE.executeQuery(s);
		
		if (rs.next()) {
			result.append(rs.getInt(1));
		}
		
		rs.close();
		s.close();
	}
	protected void addNumberOfResponses(Connection conn, StringBuffer result) throws Exception {
		ResultSet rs = null;
		PreparedStatement  s = conn.prepareStatement("select count(*) from ojb_task where META_TASK_ID in (select ID from ojb_meta_task where PROC_INST_ID=? and ND_NM='" + this.getProcessInstanceName() + ".GroupPRMemberRequest') and STUS ='P'");
		s.setString(1, this.getProcessInstanceId());
		rs = SqlExecWrapper.INSTANCE.executeQuery(s);
		
		if (rs.next()) {
			result.append(rs.getInt(1));
		}
		
		rs.close();
		s.close();
	}
	protected void addListUnfinishedUsers(Connection conn, StringBuffer result) throws Exception {
		ResultSet rs = null;
		PreparedStatement  s = conn.prepareStatement("select ASND_USR_ID from ojb_task where META_TASK_ID in (select ID from ojb_meta_task where PROC_INST_ID=? and ND_NM='" + this.getProcessInstanceName() + ".GroupPRMemberRequest') and STUS in('A', 'C', 'H')");
		s.setString(1, this.getProcessInstanceId());
		rs = SqlExecWrapper.INSTANCE.executeQuery(s);
		
		while (rs.next()) {
			result.append(rs.getString(1));
			result.append(Lang.NEW_LINE);
		}
		
		rs.close();
		s.close();
	}
	protected void addEndTime(Connection conn, StringBuffer result) throws Exception {
		ResultSet rs = null;
		PreparedStatement  s = conn.prepareStatement("select END_TM from ojb_node_log where PROC_INST_ID=? and ND_NM='" + this.getProcessInstanceName() + ".EndGroupPR'");
		s.setString(1, this.getProcessInstanceId());
		rs = SqlExecWrapper.INSTANCE.executeQuery(s);
		
		if (rs.next()) {
			result.append(rs.getTimestamp(1));
		}
		
		rs.close();
		s.close();
	}
	
	public static void main(String[] args) throws  Exception{
//		Connection conn = ConnectionManager.INSTANCE.getConnection();
		Connection conn = DatabaseManager.INSTANCE.getConnection();
		TrackInfo ti = new TrackInfo("2d73a82a-3bdb-4650-b707-bc5c705ef685");
		System.out.println(ti.getInfo(conn, ID_START_TIME));
		System.out.println(ti.getInfo(conn, ID_NUMB_OF_MEMEBERS));
		System.out.println(ti.getInfo(conn, ID_NUMB_OF_RESPONSES));
		System.out.println(ti.getInfo(conn, ID_LIST_UNFINISHED_USERS));
		System.out.println(ti.getInfo(conn, ID_END_TIME));
		String tm1 = ti.getInfo(conn, ID_START_TIME);
		String tm2 = ti.getInfo(conn, ID_END_TIME);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");  
		Date d1 = df.parse(tm1);  
		Date d2 = df.parse(tm2);  
		long diffInSeconds = (Math.abs(d2.getTime() - d1.getTime()))/1000;  
		System.out.println("diff = " + diffInSeconds + " sec");
		conn.close();
//		ConnectionManager.INSTANCE.closeConnection(conn);

		DatabaseManager.INSTANCE.closeDatabase();
	}
}
 