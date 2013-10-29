package tsunagi.example.processModel.node.infomational;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGeneric;
import tsunagi.core.util.TempLogger;

public class NodeInfoDoSomthing2 extends NodeGeneric {
	public NodeInfoDoSomthing2(String name) {
		this.setName(name);
		this.setDescription("This Node has to do the second something good.");
	}

	@Override
	protected ResultInfo process(InitialInfo info) {
		TempLogger.logNodeMessasge(this.getId(), this.getName(), this.getStartTime(), "Node Do Something 2 processed.");
		String val = (String)this.getNodeMessage().getObject("proc1");
		this.getNodeMessage().setObject("proc2", val + " World");
		return new ResultInfo();
	}
}
