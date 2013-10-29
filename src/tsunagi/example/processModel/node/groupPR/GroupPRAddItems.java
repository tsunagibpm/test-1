package tsunagi.example.processModel.node.groupPR;

import tsunagi.core.db.sql.SqlProcInst;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGeneric;
import tsunagi.core.util.TempLogger;
import tsunagi.web.DynamicDomain;

public class GroupPRAddItems extends NodeGeneric {
	public GroupPRAddItems() {
		this.setName("AddItems");
		this.setDescription("This Node add purchase request item to ProcessContext.");
	}

	@Override
	protected ResultInfo process(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		Goods goods = (Goods)this.getProcessContext().getObject(GroupPRStartNode.KEY_ITEMS);
		Good good1 = this.getGood(domain, "item1", "unit1");
		Good good2 = this.getGood(domain, "item2", "unit2");
		Good good3 = this.getGood(domain, "item3", "unit3");
		if (good1 != null) goods.add(good1);
		if (good2 != null) goods.add(good2);
		if (good3 != null) goods.add(good3);
		SqlProcInst spi = SqlProcInst.getInstance();
		spi.updateContextWithLock(this.getConnection(), this.getProcessInstanceId(), initInfo.getUserId(), this.getProcessContext());
		this.getNodeMessage().setObject("requester", domain.getValue("requester"));
		TempLogger.logNodeMessasge(this.getId(), this.getName(), this.getStartTime(), "GroupPRAddItems processed.");
		return new ResultInfo();
	}
	protected Good getGood(DynamicDomain domain, String name, String unit) {
		Good good = null;
		String item = domain.getValue(name);
		if (item != null && !"".equals(item)) {
			good = new Good();
			good.name = item;
			good.unit = Integer.parseInt(domain.getValue(unit));
		}
		return good;
	}
}
