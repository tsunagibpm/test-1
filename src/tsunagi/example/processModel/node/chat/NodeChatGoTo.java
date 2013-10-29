package tsunagi.example.processModel.node.chat;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGoto;
import tsunagi.web.DynamicDomain;

public class NodeChatGoTo extends NodeGoto {
	public NodeChatGoTo() {
		this.setName("Goto_After_First_Chat");
		this.setDescription("If it's Send, then, hello back. If Done,then it's done.");
	}

	@Override
	protected ResultInfo process(InitialInfo info) {
		DynamicDomain data = (DynamicDomain)info.getDomain();
		if (data.getValue("answer").equals("Done")){
			this.setLocation("ChatMore.ChatEnd");
		}
		return new ResultInfo();
	}
}
