package tsunagi.example.processModel.node.groupPR;

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

public class GroupPRMemberRequest extends NodeUserInputTask {

	public GroupPRMemberRequest() {
		this.setName("GroupPRMemberRequest");
		this.setTaskTitle("Request items needed to buy");
		this.setPriority(Priority.MEDIUM);
		this.setTaskType(TaskType.MM);
		this.setDescription("Add items for purchase request");
	}
	
	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue("group"));
	}

	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("memberPRRequest.jsp");
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
