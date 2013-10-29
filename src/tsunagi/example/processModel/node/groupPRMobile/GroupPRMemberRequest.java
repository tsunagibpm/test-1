package tsunagi.example.processModel.node.groupPRMobile;

import tsunagi.core.info.PageInfo;

public class GroupPRMemberRequest extends tsunagi.example.processModel.node.groupPR.GroupPRMemberRequest {

	public GroupPRMemberRequest() {
		super();
	}
	
	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("memberPRRequest.jsp");
	}

	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}

}
