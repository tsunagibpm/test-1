package tsunagi.example.processModel.node.infomational;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInitialInput;


public class NodeInfoFinal extends NodeUserInitialInput {
	public NodeInfoFinal() {
		this.setName("FinalInfo");
		this.setDescription("What did we do?");
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
		pageInfo.setPageName("infoFinal.jsp");
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
