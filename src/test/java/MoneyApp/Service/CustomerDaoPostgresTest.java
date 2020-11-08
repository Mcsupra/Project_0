package MoneyApp.Service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import ConnectionUtil.ConnectionUtil;
import MoneyAppDoa.UserDaoPostgres;
import MoneyAppPojos.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoPostgresTest {
	
	public static UserDaoPostgres userDao = new UserDaoPostgres();
	
	@Mock
	private static ConnectionUtil connUtil;
	
	@Mock
	private static Connection fakeConn;
	
	private static PreparedStatement stmt;
	
	private static PreparedStatement spy;
	
	private static Connection realConnection;
	
	public static Customer testUser = new Customer(); 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		realConnection = new ConnectionUtil().createConnection();
		testUser = new Customer("gobbleking","Notmydrumstick","giblets@turkeytownnet.com","9018675309","Turkey","McDurkey");
	}

	@After
	public void tearDown() throws Exception {
		
		
		if (realConnection != null) {
			realConnection.close();
		}
		
	}

	@Test
	public void createCustomerTest() throws SQLException {
		//Prepared SQL statement prototype
		String sql = "insert into customer (username,passphrase,email,phone_num,first_name,last_name) "
				+ "values(?,?,?,?,?,?);";
		
		try {
			preparedHelper(sql);
		}catch(SQLException e) {
			fail("SQLException thrown: " + e.toString());
		}
		
		
		try {
			userDao.createCustomer(testUser);
			
			verify(spy).setString(1, testUser.getUsername());
			verify(spy).setString(2, testUser.getPassword());
			verify(spy).setString(3, testUser.getEmail());
			verify(spy).setString(4, testUser.getPhoneNum());
			verify(spy).setString(5, testUser.getFirstName());
			verify(spy).setString(6, testUser.getLastName());
			
			verify(spy).executeUpdate();

		}catch (SQLException e) {
			fail("Exception thrown: " + e);
		}finally {
			try {
				stmt = realConnection.prepareStatement("delete from customer where first_name = 'Turkey' AND last_name = 'McDurkey'");
				stmt.executeUpdate();
			}catch(SQLException e) {
				fail("Error: Could not remove added player");
			}
		}	
		
	}
	
	@Test
	public void readCustomerTest() throws SQLException {
		
		String sql = "insert into customer(username,passphrase,email,phone_num,first_name,last_name)"
				+" values ('gobbleking','Notmydrumstick','giblets@turkeytownnet.com','9018675309','Turkey','McDurkey');";
		
		stmt = realConnection.prepareStatement(sql);
		stmt.executeUpdate();
		
		//Prepared SQL statement prototype
		sql = "select * from customer where username = ?";
		
		try {
			preparedHelper(sql);
		}catch(SQLException e) {
			fail("SQLException thrown: " + e.toString());
		}
		
		try {
			
			Customer testCustomer = userDao.readCustomer(testUser.getUsername());
			verify(spy).setString(1, testUser.getUsername());
			verify(spy).executeQuery();
			
			assertEquals(true, testCustomer.equals(testUser));
			
		}catch (SQLException e) {
			fail("Exception thrown: " + e);
		}finally {
			try {
				stmt = realConnection.prepareStatement("delete from customer where first_name = 'Turkey' AND last_name = 'McDurkey'");
				stmt.executeUpdate();
			}catch(SQLException e) {
				fail("Error: Could not remove added player");
			}
		}	
		
	}
	
	@Test
	public void ReadAllCustomerTest() throws SQLException {
		
		//Baseline of test is number in table
		String sql = "select count(*) from customer";
		int num_in_table = -1;
		System.out.println(num_in_table);
		try {
			stmt = realConnection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			num_in_table = rs.getInt(1);
			System.out.println(num_in_table);
		}catch (SQLException e) {
			System.out.println("SQLException thrown: " + e.toString());
		}
		
		
		//Prepared SQL statement prototype*/
		sql = "select * from customer";
		
		try {
			preparedHelper(sql);
		}catch(SQLException e) {
			fail("SQLException thrown: " + e.toString());
		}
		
		try {
			
			Customer testCustomer = userDao.readCustomer(testUser.getUsername());
			verify(spy).setString(1, testUser.getUsername());
			verify(spy).executeQuery();
			
			assertEquals(true, testCustomer.equals(testUser));
			
		}catch(SQLException e) {
			fail("Exception thrown: " + e);
		}
		
	}
	
	
	
	private void preparedHelper(String sql) throws SQLException {
		
		userDao.setConnUtil(connUtil);
		
		//creating a real stmt from a connection
		stmt = realConnection.prepareStatement(sql); 
		
		//spying on that real stmt
		spy = Mockito.spy(stmt);
		
		//mock our connection and util, so we will only use the stmt we are spying on
		when(connUtil.createConnection()).thenReturn(fakeConn);
		when(fakeConn.prepareStatement(sql)).thenReturn(spy);
		
		
	}

}
