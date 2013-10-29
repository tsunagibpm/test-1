package tsunagi.example.processModel.node.chat;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInputTask;
import tsunagi.core.security.UserManager;
import tsunagi.web.DynamicDomain;


public class NodeChatResponse extends NodeUserInputTask {
	public NodeChatResponse() {
		this.setName("NodeChatResponse");
		this.setDescription("Chat Response");
		this.setTaskTitle("Chat Back");
	}


	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue("friend"));
	}

	@Override
	protected boolean validate(TaskInfo arg0) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("chatResponse.jsp");
	}


	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}



}
