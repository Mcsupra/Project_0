package MoneyApp.Service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import MoneyAppPojos.User;
import MoneyAppServices.UserSignInServiceImpl;

public class UserSignInTests {

	private UserSignInServiceImpl userSignIn;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createUserTest() {
		
		
		User userRef = new User("Michael Zide", "M.zide1212", "Ilikespookyghosts123!", "myEmail@gmail.com", "86753099");
		User userTest = userSignIn.createUser("Michael Zide", "M.zide1212", "Ilikespookyghosts123!", "myEmail@gmail.com", "86753099");
		
		assertEquals("Should create a user object",userTest.equals(userRef));
	}

}
