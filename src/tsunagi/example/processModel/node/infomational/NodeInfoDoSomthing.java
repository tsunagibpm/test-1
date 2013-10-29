package tsunagi.example.processModel.node.infomational;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGeneric;
import tsunagi.core.util.TempLogger;

public class NodeInfoDoSomthing extends NodeGeneric {
	public NodeInfoDoSomthing(String name) {
		this.setName(name);
		this.setDescription("This Node has to do something good.");
	}

	@Override
	protected ResultInfo process(InitialInfo info) {
		TempLogger.logNodeMessasge(this.getId(), this.getName(), this.getStartTime(), "Node Do Something processed.");
		this.getNodeMessage().setObject("proc1", "Hello");
		return new ResultInfo();
	}
}
