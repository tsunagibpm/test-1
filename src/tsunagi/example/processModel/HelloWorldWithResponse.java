package tsunagi.example.processModel;

import tsunagi.example.processModel.node.helloworld.NodeHelloWorldGoTo;
import tsunagi.example.processModel.node.helloworld.NodeHelloWorldResponse;
import tsunagi.example.processModel.node.helloworld.NodeHelloWorldReview2;

public class HelloWorldWithResponse extends HelloWorld {
	public static final String PROC_MODL_ID = "a9ce9a8b-2e9e-434f-a562-4e3c177c4b15";

	public HelloWorldWithResponse() {
		this.setName("HolleWorldWithResponse");
		this.setDescription("Hello World to OJB and Final Response!");
		
	}
	
	public void addNodes() {
		super.addNodes();
		this.replaceNode(2, new NodeHelloWorldReview2());
		this.addNode(3, new NodeHelloWorldGoTo());
		this.addNode(4, new NodeHelloWorldResponse());
	}
}
