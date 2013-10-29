package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeWaitForAll;
import tsunagi.example.processModel.node.groupPR.GroupPRAddItems;
import tsunagi.example.processModel.node.groupPR.GroupPRMemberRequest;
import tsunagi.example.processModel.node.groupPR.GroupPRNodeTrack;
import tsunagi.example.processModel.node.groupPR.GroupPRRequest;
import tsunagi.example.processModel.node.groupPR.GroupPRReview;
import tsunagi.example.processModel.node.groupPR.GroupPRStartNode;


public class GroupPR extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "0d176230-af84-4e0e-91cf-e4a03e569313";

	public GroupPR() {
		super();
		this.setName("GroupPR");
		this.setDescription("Ask group member to submit purchase request and summarize into one purchase request.");
		
	}

	@Override
	public void addNodes() {
		this.addNode(new GroupPRStartNode());
		this.addNode(new GroupPRRequest()); // initial input
		this.addNode(new GroupPRNodeTrack());
		this.addNode(new GroupPRMemberRequest()); //MM task: member PR 
		this.addNode(new GroupPRAddItems());
		this.addNode(new NodeWaitForAll("WaitForAll"));
		this.addNode(new GroupPRReview());	//MO task
		this.addNode(new NodeEnd("EndGroupPR"));
	}
}
