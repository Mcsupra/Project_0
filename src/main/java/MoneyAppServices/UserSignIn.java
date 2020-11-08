  
package MoneyAppServices;



import MoneyAppPojos.Customer;

public interface UserSignIn {
	
	//Create User if retrieve User is false
	public Customer createUser(String username, String password, String email, String phoneNum, String firstName, String lastName);	
	
	//Sign in user if password is successful
	public boolean signIn(String username, String password);

}
