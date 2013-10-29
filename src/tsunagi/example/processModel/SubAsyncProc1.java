package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeStart;
import tsunagi.example.processModel.node.infomational.NodeInfoDoSomthing;
import tsunagi.example.processModel.node.infomational.NodeInfoDoSomthing2;
import tsunagi.example.processModel.node.infomational.NodeInformational;

public class SubAsyncProc1 extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "1b970653-eec7-4314-bce8-c2eb56a32305";

	public SubAsyncProc1() {
		super();
		this.setName("SubAsynProcessing1");
		this.setDescription("Sub Asynchronous Node Processing 1");
	}

	public void addNodes() {
		this.addNode(new NodeStart("StartSubAsyncProc1"));
		this.addNode(new NodeInfoDoSomthing("DoSome1"));
		this.addNode(new NodeInfoDoSomthing2("DoSome2"));
		this.addNode(new NodeInformational());
		this.addNode(new NodeEnd("EndSubAsyncProc1"));
	}
}
