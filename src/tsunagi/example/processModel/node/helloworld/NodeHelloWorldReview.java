package tsunagi.example.processModel.node.helloworld;

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

public class NodeHelloWorldReview extends NodeUserInputTask {

	public NodeHelloWorldReview() {
		this.setName("HelloWorldReview");
		this.setTaskTitle("Review Hello World");
		this.setPriority(Priority.MEDIUM);
		this.setTaskType(TaskType.MO);
		this.setDescription("Hello World Review User Input Task Node");
	}
	
	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue("reviewer"));
	}

	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("helloWorldReview.jsp");
		pageInfo.setUrl("helloWorldReview.jsp");
	}

	@Override
	protected boolean validate(TaskInfo taskInfo) {
		return true;
	}

	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
		pageInfo.setUrl("index.jsp");
	}

}
