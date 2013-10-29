package tsunagi.example.processModel.node.helloworld;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGoto;
import tsunagi.web.DynamicDomain;

public class NodeHelloWorldGoTo extends NodeGoto {
	public NodeHelloWorldGoTo() {
		this.setName("Goto_After_First_Hello");
		this.setDescription("If it's yes, then, hello back. If no,then it's done.");
	}

	@Override
	protected ResultInfo process(InitialInfo info) {
		DynamicDomain data = (DynamicDomain)info.getDomain();
		if (data.getValue("answer").equals("no")){
			this.setLocation("HolleWorldWithResponse.EndHelloWorld");
		}
		return new ResultInfo();
	}
}
