package MoneyAppDoa;

import java.sql.SQLException;

import MoneyAppPojos.Customer;

public interface UserDao {
		/**
		 * Create user in db
		 */
		public void createCustomer (Customer user) throws SQLException;
		
		public Customer readCustomer(String username) throws SQLException;
		
		public Customer readAllCustomers() throws SQLException;
		
		public Customer updateCustomer(String username, Customer user) throws SQLException;
		
		public void deleteCustomer(Customer user)throws SQLException ;
		
}
