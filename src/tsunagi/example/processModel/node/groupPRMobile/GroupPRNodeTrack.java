package tsunagi.example.processModel.node.groupPRMobile;

import tsunagi.core.info.PageInfo;


public class GroupPRNodeTrack extends tsunagi.example.processModel.node.groupPR.GroupPRNodeTrack {
	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("groupPR/groupPRTrackInfo.jsp");
	}

}
