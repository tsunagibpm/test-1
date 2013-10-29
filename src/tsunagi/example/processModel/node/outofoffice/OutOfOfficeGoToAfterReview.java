package tsunagi.example.processModel.node.outofoffice;

import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.ResultInfo;
import tsunagi.core.node.NodeGoto;
import tsunagi.core.util.TempLogger;
import tsunagi.web.DynamicDomain;

public class OutOfOfficeGoToAfterReview extends NodeGoto {
	public OutOfOfficeGoToAfterReview() {
		this.setName("Goto_After_Review");
		this.setDescription("If reviewer decision is 'Ok', it ends; if not, it goes back to OOOReqPM.StartOutOfOfficeRequest Node.");
	}

	@Override
	protected ResultInfo process(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		if (domain.getValue("reviewDecision").equals("No")){
			this.setLocation("OOOReqPM.OOORequest");
		} else if (Integer.parseInt(domain.getValue("days")) > 20) {
			this.setLocation("OOOReqPM.OOOReview2");
		}else {
			this.setLocation("OOOReqPM.NodeInformational");
		}
		TempLogger.logNodeMessasge(this.getId(), this.getName(), this.getStartTime(), "Node Goto After Review processed.");
		
		return new ResultInfo();
	}
}
