package tsunagi.example.security;

import java.util.List;

import tsunagi.core.security.IContactInfo;
import tsunagi.core.security.IGroup;
import tsunagi.core.security.IUser;

public class ExampleUser implements IUser {
	private String id;
	@Override
	public String getId() {
		return this.id;
	}
	public void setId(String value){
		this.id = value;
	}
	@Override
	public IContactInfo getContactInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<IGroup> getGroups() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean belongTo(String IGroup) {
		// TODO Auto-generated method stub
		return false;
	}

}
