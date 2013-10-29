package tsunagi.example.processModel;

import tsunagi.core.node.NodeEnd;
import tsunagi.example.processModel.node.groupPR.GroupPRNodeTrack;
import tsunagi.example.processModel.node.groupPR.GroupPRRequest;


public class GroupPRMobile extends GroupPR {
	public static final String PROC_MODL_ID = "15619691-7463-4f69-b15f-39b7e5ce2127";

	public GroupPRMobile() {
		super();
		this.setName("GroupPRMobile");
		this.setDescription("Ask group member to submit purchase request and summarize into one purchase request.");
		
	}

	@Override
	public void addNodes() {
		super.addNodes();
		this.replaceNode(1, new GroupPRRequest()); //this.addNode(new GroupPRRequest()); // initial input
		this.replaceNode(2, new GroupPRNodeTrack()); //
		//this.replaceNode(3, node); // //MM task: member PR 
		//this.addNode(new GroupPRAddItems());
		//this.addNode(new NodeWaitForAll("WaitForAll"));
		//this.replaceNode(6, node); //	//MO task
		this.replaceNode(7, new NodeEnd("EndGroupPRMobile")); //this.addNode(new NodeEnd("EndGroupPR"));
	}
}
