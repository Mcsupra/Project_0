package MoneyAppServices;

import java.util.Map;

import MoneyAppPojos.User;

public class UserSignInServiceImpl implements UserSignIn{
	
	
	
	public UserSignInServiceImpl() {
		super();
	}
	
	
	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User createUser(String firstNameLastName, String username, String password, String email, String phoneNum) {
		
		User newUser = new User(firstNameLastName, username, password, email, phoneNum);
		
		return newUser;
	}

	@Override
	public boolean signIn(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void signOut(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String> allUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}