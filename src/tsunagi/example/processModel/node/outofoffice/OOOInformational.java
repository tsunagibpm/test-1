package tsunagi.example.processModel.node.outofoffice;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.info.InitialInfo;
import tsunagi.core.info.PageInfo;
import tsunagi.core.security.UserManager;
import tsunagi.example.processModel.node.infomational.NodeInformational;
import tsunagi.web.DynamicDomain;


public class OOOInformational extends NodeInformational {

	public OOOInformational() {
		this.setName("NodeInformational");
		this.setTaskTitle("Out Of Office Request Accepted");
	}
	@Override
	protected ArrayList<MetaTaskAssigned> buildAssignment(InitialInfo initInfo) {
		DynamicDomain domain = (DynamicDomain)initInfo.getDomain();		return UserManager.INSTANCE.getUserProcessor().getMetaTaskAssigned(domain.getValue("requester"));
	}


	@Override
	protected void setPageInfoForOpenTask(PageInfo pageInfo) {
		pageInfo.setPageName("OOOInfo.jsp");
	}

}
