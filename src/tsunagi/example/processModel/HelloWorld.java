package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeStart;
import tsunagi.example.processModel.node.helloworld.NodeHelloWorldRequest;
import tsunagi.example.processModel.node.helloworld.NodeHelloWorldReview;

public class HelloWorld extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "5212f281-3a74-4bcc-ac37-7f7065719619";

	public HelloWorld() {
		super();
		this.setName("HolleWorld");
		this.setDescription("Hello World to Tsunagi!!");
	}

	public void addNodes() {
		this.addNode(new NodeStart("StartHelloWorld"));
		this.addNode(new NodeHelloWorldRequest());
		this.addNode(new NodeHelloWorldReview());
		this.addNode(new NodeEnd("EndHelloWorld"));
	}
}
