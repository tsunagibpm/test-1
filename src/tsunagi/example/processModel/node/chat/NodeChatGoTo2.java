package tsunagi.example.processModel.node.chat;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGoto;
import tsunagi.web.DynamicDomain;

public class NodeChatGoTo2 extends NodeGoto {
	public NodeChatGoTo2() {
		this.setName("Goto_After_Second_Chat");
		this.setDescription("If it's Send, then, hello back. If Done,then it's done.");
	}

	@Override
	protected ResultInfo process(InitialInfo info) {
		DynamicDomain data = (DynamicDomain)info.getDomain();
		if (data.getValue("answer").equals("Send")){
			this.setLocation("ChatMore.NodeChatResponse");
		}
		return new ResultInfo();
	}
}
