package tsunagi.example.processModel.node.outofoffice;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInputTask;
import tsunagi.core.security.UserManager;
import tsunagi.core.type.Priority;
import tsunagi.core.type.TaskType;
import tsunagi.web.DynamicDomain;

public class OutOfOfficeReview extends NodeUserInputTask {

	public OutOfOfficeReview() {
		this.setName("OOOReview");
		this.setTaskTitle("Review Out Of Office Request");
		this.setPriority(Priority.MEDIUM);
		this.setTaskType(TaskType.MO);
		this.setDescription("Out of Office Request Review User Input Task Node");
	}
	
	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue("reviewer"));
	}

	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("OOOReview.jsp");
	}

	@Override
	protected boolean validate(TaskInfo taskInfo) {
		boolean result = true;
//		DynamicDomain domain = (DynamicDomain)taskInfo.getDomain();
		
//		ooo.setReviewerAction("Good");
//		ooo.setReviewerAction("Not Good");
//		ooo.setReviewerAction("Validation Error");
		
//		if (domain.getValue("").equals("Validation Error")) {
//			result = false;
//			resultInfo.getPageInfo().setPageName("Out of Office Request Review Page");
//			resultInfo.getPageInfo().setUrl("ooreq-revew-page.html");
//			resultInfo.setContinueProcessingFlag(false);
//		}
		return result;
	}

	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}

}
