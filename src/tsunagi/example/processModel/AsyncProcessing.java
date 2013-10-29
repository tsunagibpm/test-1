package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeStart;
import tsunagi.core.node.NodeSubProcessAsync;
import tsunagi.example.processModel.node.infomational.NodeInfoDoSomthing;
import tsunagi.example.processModel.node.infomational.NodeInfoDoSomthing2;
import tsunagi.example.processModel.node.infomational.NodeInfoFinal;
import tsunagi.web.SubProcessInstanceRunner;

public class AsyncProcessing extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "33951899-6958-43db-a579-5a256ddea813";

	public AsyncProcessing() {
		super();
		this.setName("AsynProcessing");
		this.setDescription("Asynchronous Node Processing");
	}

	public void addNodes() {
		this.addNode(new NodeStart("StartAsyncProc"));
		this.addNode(new NodeSubProcessAsync("SubAsyncProc1", SubAsyncProc1.PROC_MODL_ID, new SubProcessInstanceRunner()));
		this.addNode(new NodeInfoDoSomthing("DoSome1"));
		this.addNode(new NodeInfoDoSomthing2("DoSome2"));
		this.addNode(new NodeInfoFinal());
		this.addNode(new NodeEnd("EndAsyncProc"));
	}
}
