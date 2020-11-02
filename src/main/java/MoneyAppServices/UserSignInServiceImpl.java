package MoneyAppServices;


import MoneyAppPojos.User;

public class UserSignInServiceImpl implements UserSignIn{
	
	private CacheServiceSIM<User> userCache = new CacheServiceSIM<User>();
	
	public UserSignInServiceImpl() {
		super();
	}
		

	public CacheServiceSIM<User> getUserCache() {
		return userCache;
	}


	public void setUserCache(CacheServiceSIM<User> userCache) {
		this.userCache = userCache;
	}




	@Override
	public User createUser(String firstNameLastName, String username, String password, String email, String phoneNum) {
		
		User newUser = new User(firstNameLastName, username, password, email, phoneNum);
		//adding user object to cache
		userCache.addToCache(username, newUser);
		
		return newUser;
	}


	@Override
	public boolean signIn(String username, String password) {
		// write code that confirms a user identity
		//		Check List/Set for a username Compare that username to the password value
		
		try {
			return(userCache.retrieveItemFromCache(username).getPassword().equals(password));
			
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	

	/*@Override
	public void signOut() {
		// TODO exit the program
		//  	Press '0' exit out of loop
		
	}*/


	
	
	 
}