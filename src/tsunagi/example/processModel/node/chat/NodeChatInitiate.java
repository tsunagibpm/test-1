package tsunagi.example.processModel.node.chat;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInitialInput;


public class NodeChatInitiate extends NodeUserInitialInput {
	public NodeChatInitiate() {
		this.setName("NodeChatInitiate");
		this.setDescription("Chat Initiator");
	}


	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		return null;
	}


	@Override
	protected boolean validate(InitialInfo initInfo) {
		return true;
	}



	@Override
	protected void setPageInfoForPrepareInput(PageInfo pageInfo) {
		pageInfo.setPageName("chatInitiate.jsp");
	}
	

	@Override
	protected void setPageInfoForProcessInput(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
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
