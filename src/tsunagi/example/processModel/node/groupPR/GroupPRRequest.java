package tsunagi.example.processModel.node.groupPR;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInitialInput;


public class GroupPRRequest extends NodeUserInitialInput {
	public GroupPRRequest() {
		this.setName("GroupPRRequest");
		this.setDescription("Select a group for purchase.");
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
		pageInfo.setPageName("groupPRRequest.jsp");
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
