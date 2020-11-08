package MoneyAppServices;


import org.apache.log4j.Logger;

import MoneyAppPojos.Customer;


public class UserSignInServiceImpl implements UserSignIn{
	
	private CacheServiceSIM<Customer> userCache = new CacheServiceSIM<Customer>();
	private static Logger log = Logger.getLogger("UserSignInService");
	
	public UserSignInServiceImpl() {
		super();
	}
		

	public CacheServiceSIM<Customer> getUserCache() {
		return userCache;
	}


	public void setUserCache(CacheServiceSIM<Customer> userCache) {
		this.userCache = userCache;
	}


	
	/**
	 * Creates a user obj and stores it in the the user cache
	 * String firstNameLastName, String username, String password, String email, String phoneNum
	 * If username already exists, don't add it
	 * @return User
	 */
	@Override
	public Customer createUser(String firstName, String lastName, String username, String password, String email, String phoneNum) {
		
		Customer newUser = new Customer(firstName, lastName, username, password, email, phoneNum);
		if (!userCache.getCache().containsKey(username)) {
			userCache.addToCache(username, newUser);
			
			return newUser;
		}
		else {
			return null;
		}
		
		
	}

	/**
	 * Checks for the username in the user cache and compares password
	 * String username, String password
	 * @return boolean
	 */
	@Override
	public boolean signIn(String username, String password) {
		
		try {
			return(userCache.retrieveItemFromCache(username).getPassword().equals(password));
			
		} catch (NullPointerException e) {
			log.error("NULLpointE");
			return false;
		}
	}
	 
}