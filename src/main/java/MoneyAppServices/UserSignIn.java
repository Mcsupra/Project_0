  
package MoneyAppServices;



import MoneyAppPojos.User;

public interface UserSignIn {
	
	//Create User if false
	public User createUser(String firstNameLastName, String username, String password, String email, String phoneNum);	
	
	//Sign in user if password is successful
	public boolean signIn(User user);
	
	//Sign out
	public void signOut(User user);
	

}
