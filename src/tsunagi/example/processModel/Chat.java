package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeStart;
import tsunagi.example.processModel.node.chat.NodeChatInitiate;
import tsunagi.example.processModel.node.chat.NodeChatReceive;

public class Chat  extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "76107657-2b75-49e3-b55a-cbeafe14af45";

	public Chat() {
		super();
		this.setName("Chat");
		this.setDescription("Chat over tasks");
	}

	@Override
	public void addNodes() {
		this.addNode(new NodeStart("ChatStart"));
		this.addNode(new NodeChatInitiate()).addNode(new NodeChatReceive());
		this.addNode(new NodeEnd("ChatEnd"));  
	}

}
