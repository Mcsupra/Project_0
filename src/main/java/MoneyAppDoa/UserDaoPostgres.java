package MoneyAppDoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionUtil.ConnectionUtil;
import MoneyAppPojos.Customer;

public class UserDaoPostgres implements UserDao {
	
		private PreparedStatement statement;
		
		public ConnectionUtil connUtil = new ConnectionUtil();
		
		public void setConnUtil(ConnectionUtil connUtil) {
			this.connUtil = connUtil;
		}
		
		@Override
		public void createCustomer(Customer user) throws SQLException {
			
			String sql = "insert into customer (username,passphrase,email,phone_num,first_name,last_name) "
					+ "values(?,?,?,?,?,?);";

			try {
					statement = connUtil.createConnection().prepareStatement(sql);
					statement.setString(1,user.getUsername());
					statement.setString(2,user.getPassword());
					statement.setString(3,user.getEmail());
					statement.setString(4,user.getPhoneNum());
					statement.setString(5,user.getFirstName());
					statement.setString(6,user.getLastName());
					statement.executeUpdate();
					
			} catch (SQLException e) {
						// TODO Add log
						e.printStackTrace();
			}
					
		}
	
		@Override
		public Customer readCustomer(String username) throws SQLException {
			
			
			String sql = "select * from customer where username = ?";
			

			try {
					statement = connUtil.createConnection().prepareStatement(sql);
					statement.setString(1, username);
					ResultSet rs = statement.executeQuery();
					rs.next();
					Customer returnedCustomer = new Customer(rs.getString(1),
															 rs.getString(2),
															 rs.getString(3),
															 rs.getString(4),
															 rs.getString(5),
															 rs.getString(6));
					return returnedCustomer;
					
			}catch (SQLException e) {
				//TODO Add Logger
				return null;
			}
			
			
		}
	
		@Override
		public Customer readAllCustomers() {
			// TODO Auto-generated method stub
			return null;
		}
	
		@Override
		public Customer updateCustomer(String username, Customer user) {
			// TODO Auto-generated method stub
			return null;
		}
	
		@Override
		public void deleteCustomer(Customer user) {
			// TODO Auto-generated method stub
			
		}

}
