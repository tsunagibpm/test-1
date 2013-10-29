package tsunagi.example.security;

import java.util.ArrayList;

import tsunagi.core.domain.MetaTaskAssigned;
import tsunagi.core.security.IUser;
import tsunagi.core.security.IUserProcessor;
import tsunagi.core.type.AssignType;

public class ExampleUserProcessor implements IUserProcessor {

	public static final String GROUP_REVIEWER_1 = "groupReviewer1";
	public static final String GROUP_REVIEWER_2 = "groupReviewer2";
	public static final String USER_TEST_1 = "userTester1";
	public static final String USER_TEST_2 = "userTester2";
	public static final String USER_TEST_3 = "userTester3";
	public static final String USER_TEST_4 = "userTester4";
	public static final String USER_TEST_5 = "userTester5";
	public static final String[] MEMBER_REVIEWER_1 = new String[]{USER_TEST_2, USER_TEST_3};
	public static final String[] MEMBER_REVIEWER_2 = new String[]{USER_TEST_4, USER_TEST_5};

	@Override
	public ArrayList<MetaTaskAssigned> getMetaTaskAssigned(Object obj) {
		String id = (String)obj;
		ArrayList<MetaTaskAssigned> result = new ArrayList<MetaTaskAssigned>();
		MetaTaskAssigned mta = new MetaTaskAssigned();
		mta.setAssignedId(id);
		if (id.indexOf("user") == 0) {
			mta.setAssignedType(AssignType.PERSON.getCode());
		}else {
			mta.setAssignedType(AssignType.GROUP.getCode());
		}
		result.add(mta);
		return result;
	}
	@Override
	public ArrayList<IUser> getUsers(ArrayList<MetaTaskAssigned> assigned) {
		ArrayList<IUser> result = new ArrayList<IUser>();
		for(MetaTaskAssigned one: assigned) {
			if (GROUP_REVIEWER_1.equals(one.getAssignedId())) {
				IUser user = new ExampleUser();
				user.setId(USER_TEST_2);
				result.add(user);
				user = new ExampleUser();
				user.setId(USER_TEST_3);
				result.add(user);
			}else if (GROUP_REVIEWER_2.equals(one.getAssignedId())) {
				IUser user = new ExampleUser();
				user.setId(USER_TEST_4);
				result.add(user);
				user = new ExampleUser();
				user.setId(USER_TEST_5);
				result.add(user);
			}else {
				IUser user = new ExampleUser();
				user.setId(one.getAssignedId());
				result.add(user);
			}
		}
		return result;
	}

}
