package tsunagi.example.processModel.node.groupPR;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.node.NodeUserInformationalTask;
import tsunagi.core.security.UserManager;
import tsunagi.web.DynamicDomain;
import tsunagi.web.property.FormProperties;


public class GroupPRNodeTrack extends NodeUserInformationalTask {
	public GroupPRNodeTrack() {
		this.setName("GroupPRNodeTrack");
		this.setDescription("Track processes of GROUP PR");
		this.setTaskTitle("Review Process Tracking Info");
	}


	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();
		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue(FormProperties.USER_ID));
	}


	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("groupPRTrackInfo.jsp");
	}


	@Override
	protected void setPageInfoForProcessTask(PageInfo pageInfo) {
		pageInfo.setPageName("index.jsp");
	}



}
