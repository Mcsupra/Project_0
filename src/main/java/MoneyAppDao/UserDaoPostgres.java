package MoneyAppDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		public List<Customer> readAllCustomers() {
			
			List<Customer> allCust = new ArrayList<>();
			
			String sql = "select * from customer";
			
			try {
					statement = connUtil.createConnection().prepareStatement(sql);
					ResultSet rs = statement.executeQuery();
					while(rs.next()) {
						Customer returnedCustomer = new Customer(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
						
						allCust.add(returnedCustomer);
					
					}
					return allCust;
					
			}catch(SQLException e) {
				return null;
			}
		}
	
		@Override
		public void updateCustomer(Customer user) {
			
			try { //Prepare prepared statement
	            String sql = "UPDATE customer SET passphrase = ?, " 
	        			+ "email = ?, phone_num = ?, first_name = ?, last_name = ? "
	        			+ "WHERE username = ?;";

	            statement = connUtil.createConnection().prepareStatement(sql);
	            statement.setString(1, user.getPassword());
	            statement.setString(2, user.getEmail());
	            statement.setString(3, user.getPhoneNum());
	            statement.setString(4, user.getFirstName());
	            statement.setString(5, user.getLastName());
	            statement.setString(6, user.getUsername());
	            
	            statement.executeUpdate();

	        } catch (SQLException e) {
				//TODO Add Logger
			}
		}
	
		@Override
		public void deleteCustomer(String username) {
			
			String sql = "delete from customer where username = ?;";
			
			try {
				statement = connUtil.createConnection().prepareStatement(sql);
				statement.setString(1, username);
				statement.executeUpdate();
			}catch (SQLException e) {
				//TODO Add Logger
			}
		}

}
