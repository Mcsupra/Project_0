package MoneyAppServices;

import java.sql.SQLException;

import MoneyAppDoa.UserDao;
import MoneyAppDoa.UserDaoPostgres;
import MoneyAppPojos.Customer;

public class UserSignInDB implements UserSignIn {
	
	UserDao userDao = new UserDaoPostgres();
	
	@Override
	public Customer createUser(String username, String password, String email, String phoneNum, String firstName, String lastName) {
		
		
		Customer newUser = new Customer(username, password, email, phoneNum, firstName, lastName);
		try {
			userDao.createCustomer(newUser);
		} catch (SQLException e) {
			// TODO Add log
			e.printStackTrace();
		}
		
		return newUser;
	}

	@Override
	public boolean signIn(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
