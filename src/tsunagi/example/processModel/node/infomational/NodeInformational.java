package tsunagi.example.processModel.node.infomational;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.node.NodeUserInformationalTask;
import tsunagi.core.security.UserManager;


public class NodeInformational extends NodeUserInformationalTask {
	public NodeInformational() {
		this.setName("NodeInformational");
		this.setDescription("Read Information");
		this.setTaskTitle("Read Information");
	}


	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned("userTester5");
	}


	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("info.jsp");
	}


	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}



}
