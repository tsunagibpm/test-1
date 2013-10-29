package tsunagi.example.util;

import tsunagi.core.cmd.ProcessModelRegister;

public class RegisterProcessModel {

	public static void main(String[] args) throws Exception {
		String[] params = new String[]{"register", "Chat", "tsunagi.example.processModel.Chat"};
//		String[] params = new String[]{"register", "ChatMore", "tsunagi.example.processModel.ChatMore"};
//		String[] params = new String[]{"register", "groupPRMobile", "example.processModel.GroupPRMobile"};
		ProcessModelRegister.main(params);
	}

}
