package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeStart;
import tsunagi.example.processModel.node.infomational.NodeInfoDoSomthing;
import tsunagi.example.processModel.node.infomational.NodeInfoDoSomthing2;
import tsunagi.example.processModel.node.infomational.NodeInfoFinal;
import tsunagi.example.processModel.node.infomational.NodeInformational;

public class Informational extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "9b98b936-dbf3-449c-bea7-e2bd40da4a61";

	public Informational() {
		super();
		this.setName("Informational");
		this.setDescription("Informational");
	}

	public void addNodes() {
		this.addNode(new NodeStart("StartInformational"));
		this.addNode(new NodeInfoDoSomthing("DoSome1"));
		this.addNode(new NodeInfoDoSomthing2("DoSome2"));
		this.addNode(new NodeInformational());
		this.addNode(new NodeInfoFinal());
		this.addNode(new NodeEnd("EndInformational"));
	}
}
