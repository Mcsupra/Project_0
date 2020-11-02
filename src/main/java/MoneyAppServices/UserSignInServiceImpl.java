package MoneyAppServices;

import java.util.Map;

import MoneyAppPojos.User;

public class UserSignInServiceImpl implements UserSignIn{
	
	//private UserCacheServiceSIM<User> userCache = new UserCacheServiceSIM<User>();
	
	public UserSignInServiceImpl() {
		super();
	}
		
	
	
	@Override
	public User createUser(String firstNameLastName, String username, String password, String email, String phoneNum) {
		
		User newUser = new User(firstNameLastName, username, password, email, phoneNum);
		//TODO implement adding user object to cache
		
		return newUser;
	}
	
	@Override
	public boolean checkUser(User user) {
		// TODO implementation: check to see if user exists in cache
		//		Check List/Set for a username. Compare that username to the password value
	
		
		return false;
	}

	

	@Override
	public boolean signIn(User user) {
		// TODO write code that confirms a user identity
		//		Check List/Set for a username Compare that username to the password value
		return false;
	}

	@Override
	public void signOut(User user) {
		// TODO exit the program
		//  	Press '0' exit out of loop
		
	}


	
	
	 
}