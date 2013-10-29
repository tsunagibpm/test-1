package tsunagi.example.processModel.node.outofoffice;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInitialInput;
import tsunagi.core.security.UserManager;
import tsunagi.web.DynamicDomain;

public class OutOfOfficeRequest extends NodeUserInitialInput {
	public OutOfOfficeRequest() {
		this.setName("OOORequest");
		this.setTaskTitle("Re-Review Out Of Office Request");
		this.setDescription("Out of Office Request User Initial Input Node");
	}


	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue("reviewer"));
	}


	@Override
	protected boolean validate(InitialInfo initInfo) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	protected void setPageInfoForProcessInput(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}


	@Override
	protected boolean validate(TaskInfo taskInfo) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("OOORequest.jsp");
	}


	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}


	@Override
	protected void setPageInfoForPrepareInput(PageInfo pageInfo) {
		pageInfo.setPageName("OOORequest.jsp");
	}



}
