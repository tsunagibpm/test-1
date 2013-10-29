package tsunagi.example.processModel;

import tsunagi.example.processModel.node.chat.NodeChatGoTo;
import tsunagi.example.processModel.node.chat.NodeChatGoTo2;
import tsunagi.example.processModel.node.chat.NodeChatResponse;
import tsunagi.example.processModel.node.chat.NodeChatResponse2;

public class ChatMore  extends Chat {
	public static final String PROC_MODL_ID = "7af4f39a-c8e0-47c7-a7ae-1ca4724e2d22";

	public ChatMore() {
		super();
		this.setName("ChatMore");
		this.setDescription("Chat more over tasks");
	}

	@Override
	public void addNodes() {
		super.addNodes();
		
		this.replaceNode(2, new NodeChatResponse());
		this.addNode(3, new NodeChatGoTo());
		this.addNode(4, new NodeChatResponse2());
		this.addNode(5, new NodeChatGoTo2());
	}

}
