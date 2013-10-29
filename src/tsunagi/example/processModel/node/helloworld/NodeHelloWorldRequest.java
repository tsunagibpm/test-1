package tsunagi.example.processModel.node.helloworld;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInitialInput;


public class NodeHelloWorldRequest extends NodeUserInitialInput {
	public NodeHelloWorldRequest() {
		this.setName("HelloWorldRequest");
		this.setDescription("Whom do you want to say hello?");
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
		pageInfo.setPageName("helloWorldRequest.jsp");
	}
	

	@Override
	protected void setPageInfoForProcessInput(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}


	@Override
	protected boolean validate(TaskInfo arg0) {
		return false;
	}


	@Override
	protected void setPageInfoForOpenTask(PageInfo arg0) {
	}


	@Override
	protected void setPageInfoForProcessTask(PageInfo arg0) {
	}



}
