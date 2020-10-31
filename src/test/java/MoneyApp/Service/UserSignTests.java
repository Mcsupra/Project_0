package MoneyApp.Service;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import MoneyAppPojos.User;
import MoneyAppServices.UserSignInServiceImpl;

public class UserSignTests {
	
	private UserSignInServiceImpl userSignin;
	
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
		
		User userTest = userSignin.createUser("Michael Zide", "M.zide1212", "Ilikespookyghosts123!", "myEmail@gmail.com", "86753099");
		
		assertEquals("Should create a user object",userTest,userSignin.createUser("Michael Zide", "M.zide1212", "Ilikespookyghosts123!", "myEmail@gmail.com", "86753099"));
	}

}
