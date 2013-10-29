package tsunagi.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsunagi.core.db.sql.SqlTask;
import tsunagi.core.domain.Task;
import tsunagi.core.type.TaskStatus;
import tsunagi.web.ConnectionManager;

@WebServlet("/Inbox")
public class Inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("uid");
		Connection conn = ConnectionManager.INSTANCE.getConnection();
		ArrayList<Task> tasks = SqlTask.getInstance().selectByUserId(conn, userId);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + userId + "'s Inbox" + "</h1>");
		out.println(this.printTasks(tasks, userId));
		out.println("<br/><br/><a href=\"index.jsp\">Start Page</a>");
		out.println("</body>");
		out.println("</html>");	
	}
	protected String printTasks(ArrayList<Task> tasks, String userId) {
		StringBuffer result = new StringBuffer();
		if (tasks.size() == 0) {
			result.append("There is no task in the Inbox.");
		}
		else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			result.append("<table border='1'>");
			result.append("<tr>");
			result.append("<th>Task Title</th>");
			result.append("<th>Status</th>");
			result.append("<th>Created By</th>");
			result.append("<th>Created Date/Time</th>");
			result.append("<th>Modified By</th>");
			result.append("<th>Modified Date/Time</th>");
			result.append("<th>Action</th>");
			result.append("</tr>");
			for(Task task: tasks) {
				result.append("<tr>");
				result.append(this.getColumnValue(task.getName()));
				result.append(this.getColumnValue(task.getStatus().getLabel()));
				result.append(this.getColumnValue(task.getMetaTask().getCreatedBy()));
				result.append(this.getColumnValue(df.format(task.getMetaTask().getCreatedTimestamp())));
				result.append(this.getColumnValue(task.getModifiedBy()));
				result.append(this.getColumnValue(df.format(task.getModifiedTimestamp())));
				if (TaskStatus.ASSIGNED.equals(task.getStatus())) {
					result.append(this.getColumnValue(this.getActionUrl(task, userId)));
				} else if (TaskStatus.HELD.equals(task.getStatus())) {
					result.append(this.getColumnValue(this.unHoldUrl(task, userId)));
				} else if (TaskStatus.ACCEPTED.equals(task.getStatus())) {
					result.append(this.getColumnValue(this.getActionUrl(task, userId)+"<br/>"+ this.releaseUrl(task, userId)+ "<br/>" + this.holdUrl(task, userId)));
				}
				result.append("</tr>");
			}
			result.append("</table>"); 
		}
		return result.toString();
	}
	protected String getColumnValue(String val){
		StringBuffer result = new StringBuffer();
		result.append("<td>");
		result.append(val);
		result.append("</td>");
		return result.toString();
	}
	protected String getActionUrl(Task task, String userId) {
		return "<a href=TaskOpener?tid=" + task.getId() + "&uid=" + userId + ">Open Task</a>";
	}
	protected String holdUrl(Task task, String userId) {
		return "<a href=TaskHolder?tid=" + task.getId() + "&uid=" + userId + ">Hold Task</a>";
	}
	protected String unHoldUrl(Task task, String userId) {
		return "<a href=TaskUnholder?tid=" + task.getId() + "&uid=" + userId + ">Unhold Task</a>";
	}
	protected String releaseUrl(Task task, String userId) {
		return "<a href=TaskReleaser?tid=" + task.getId() + "&uid=" + userId + ">Release Task</a>";
	}
}
