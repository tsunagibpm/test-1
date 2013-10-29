package tsunagi.example.processModel.node.groupPRMobile;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.info.TaskInfo;
import tsunagi.core.node.NodeUserInputTask;
import tsunagi.core.security.UserManager;
import tsunagi.core.type.Priority;
import tsunagi.core.type.TaskType;
import tsunagi.example.processModel.node.groupPR.GroupPRStartNode;

public class GroupPRReview extends NodeUserInputTask {

	public GroupPRReview() {
		this.setName("GroupPRReview");
		this.setTaskTitle("Review Group Purchase Request");
		this.setPriority(Priority.MEDIUM);
		this.setTaskType(TaskType.MO);
		this.setDescription("Reivew group purchase request");
	}
	
	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		String requester = (String)this.getNodeMessage().getObject("requester");
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(requester);
	}

	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		Object obj = this.getProcessContext().getObject(GroupPRStartNode.KEY_ITEMS);
		this.getNodeMessage().setObject(GroupPRStartNode.KEY_ITEMS, obj);
		pageInfo.setPageName("groupPRReview.jsp");
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
