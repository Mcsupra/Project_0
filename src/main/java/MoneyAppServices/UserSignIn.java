  
package MoneyAppServices;

import java.util.Map;

import MoneyAppPojos.User;

public interface UserSignIn {
	
	//Create User if false
	public User createUser(String firstNameLastName, String username, String password, String email, String phoneNum);
	
	//Check to see if user is in DB
	public boolean checkUser(User user);
	
	
	
	//Sign in user if password is successful
	public boolean signIn(User user);
	
	//Sign out
	public void signOut(User user);
	
	//Store users in DB
	public Map<String, String> allUsers();

}
