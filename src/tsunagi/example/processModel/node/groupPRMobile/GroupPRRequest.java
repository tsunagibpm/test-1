package tsunagi.example.processModel.node.groupPRMobile;

import tsunagi.core.info.PageInfo;


public class GroupPRRequest extends tsunagi.example.processModel.node.groupPR.GroupPRRequest {

	@Override
	protected void setPageInfoForPrepareInput(PageInfo pageInfo) {
		pageInfo.setPageName("groupPR/main.jsp");
	}
	

	@Override
	protected void setPageInfoForProcessInput(PageInfo pageInfo) {
		pageInfo.setPageName("groupPR/index.html");
	}

}
