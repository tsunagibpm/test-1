package tsunagi.example.processModel;

import tsunagi.core.ProcessModelSingle;
import tsunagi.core.node.NodeEnd;
import tsunagi.core.node.NodeStart;
import tsunagi.example.processModel.node.outofoffice.OOOInformational;
import tsunagi.example.processModel.node.outofoffice.OutOfOfficeGoToAfterReview;
import tsunagi.example.processModel.node.outofoffice.OutOfOfficeGoToAfterReview2;
import tsunagi.example.processModel.node.outofoffice.OutOfOfficeReview;
import tsunagi.example.processModel.node.outofoffice.OutOfOfficeReview2;


public class OOORequest extends ProcessModelSingle {
	public static final String PROC_MODL_ID = "cf5f2b50-62cc-41dc-894c-dc419345817e";

	public OOORequest() {
		super();
		this.setName("OOOReqPM");
		this.setDescription("Out of Office Request Process Model");
		
	}

	@Override
	public void addNodes() {
		this.addNode(new NodeStart("StartOutOfOfficeRequest"));
		this.addNode(new tsunagi.example.processModel.node.outofoffice.OutOfOfficeRequest());
		this.addNode(new OutOfOfficeReview());
		this.addNode(new OutOfOfficeGoToAfterReview());
		this.addNode(new OutOfOfficeReview2());
		this.addNode(new OutOfOfficeGoToAfterReview2());
		this.addNode(new OOOInformational());
		this.addNode(new NodeEnd("EndOutOfOfficeRequest"));
	}
}
