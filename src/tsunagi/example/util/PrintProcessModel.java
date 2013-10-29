package tsunagi.example.util;

import tsunagi.core.cmd.ProcessModelPrinter;
import tsunagi.example.processModel.ChatMore;

public class PrintProcessModel {
	public static void main(String[] args) {
			ProcessModelPrinter pmp = new ProcessModelPrinter();
//			pmp.print(GroupPRMobile.class.getName());
//			pmp.print(GroupPR.class.getName());
//			pmp.print(AsyncProcessing.class.getName());
//			pmp.print(SubAsyncProc1.class.getName());
//			pmp.print(Informational.class.getName());
			pmp.print(ChatMore.class.getName());
//			pmp.print(HelloWorldWithResponse.class.getName());
	}

}
