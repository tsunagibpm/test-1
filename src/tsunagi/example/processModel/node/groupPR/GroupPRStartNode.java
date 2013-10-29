package tsunagi.example.processModel.node.groupPR;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeStart;
import tsunagi.core.util.TempLogger;

public class GroupPRStartNode extends NodeStart {
	public static final String KEY_ITEMS = "items";
	
	public GroupPRStartNode() {
		this.setName("GroupPRStartNode");
		this.setDescription("Insert List object into ProcessContext for items");
	}
	@Override
	protected ResultInfo process(InitialInfo initInfo) {
		this.getProcessContext().setObject(KEY_ITEMS, new Goods());
		TempLogger.logNodeMessasge(this.getId(), this.getName(), this.getStartTime(), "Node Start processed.");
		return new ResultInfo();
	}

}
