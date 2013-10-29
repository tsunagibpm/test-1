package tsunagi.example.processModel.node.outofoffice;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.security.UserManager;
import tsunagi.example.security.ExampleUserProcessor;
import tsunagi.web.DynamicDomain;

public class OutOfOfficeReview2 extends OutOfOfficeReview {

	public OutOfOfficeReview2() {
		this.setName("OOOReview2");
		this.setTaskTitle("Review Out Of Office Request for more than 20 days");
	}
	
	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		String prevUser = domain.getValue("prevUser");
		String groupReviewer = ExampleUserProcessor.GROUP_REVIEWER_1;
		if (ExampleUserProcessor.USER_TEST_2.equals(prevUser) || ExampleUserProcessor.USER_TEST_3.equals(prevUser)) {
			groupReviewer = ExampleUserProcessor.GROUP_REVIEWER_2;
		}
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(groupReviewer);
	}

	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("OOOReview2.jsp");
	}

	@Override
	protected boolean validate(TaskInfo taskInfo) {
		boolean result = true;
		return result;
	}

	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}

}
