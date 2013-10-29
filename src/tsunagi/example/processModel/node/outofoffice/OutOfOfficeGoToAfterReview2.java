package tsunagi.example.processModel.node.outofoffice;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGoto;
import tsunagi.core.util.TempLogger;
import tsunagi.web.DynamicDomain;

public class OutOfOfficeGoToAfterReview2 extends NodeGoto {
	public OutOfOfficeGoToAfterReview2() {
		this.setName("Goto_After_Review2");
		this.setDescription("If request is more than 20 days, it comes here. If reviewer decision is 'Ok', it ends; if not, it goes back to OOOReqPM.OOOReview Node.");
	}

	@Override
	protected ResultInfo process(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		if (domain.getValue("reviewDecision").equals("No")){
			this.setLocation("OOOReqPM.OOOReview");
		}
		TempLogger.logNodeMessasge(this.getId(), this.getName(), this.getStartTime(), "Node Goto After Review2 processed.");
		
		return new ResultInfo();
	}
}
