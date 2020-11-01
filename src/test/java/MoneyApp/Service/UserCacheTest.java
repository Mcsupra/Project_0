package MoneyApp.Service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import MoneyAppPojos.User;
import MoneyAppServices.UserCacheServiceSIM;

public class UserCacheTest {
	
	private UserCacheServiceSIM<User> cacheService;
	static private  Set<User> testCache;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testCache = new HashSet<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		User testUser1 = new User("Michael Zide", "Mzide", "rEaLlYcLeVeR", "myemail24@gmail.com", "1234567890");
		User testUser2 = new User("Patrick Robertson", "bmxer4life", "HelloWorldhehe!!", "bmxer4life@hotmail.com", "(465)113-1656");
		User testUser3 = new User("Николас Юрчак", "Николас", "Николас Юрчак", "Николас Юрчак@НиколасЮрчак.net", "5553223");
		
		testCache.add(testUser1);
		testCache.add(testUser2);
		testCache.add(testUser3);
		
		cacheService = new UserCacheServiceSIM<User>(testCache);
		
	}

	@After
	public void tearDown() throws Exception {
		testCache.clear();
	}

	@Test
	public void addToCacheTest() {
		
		User cachedUserTest = new User("Michael Myers", "HalloweenLuvr1031", "Iliketoslash00?!", "epichalloween@greatmovies.org", "123213223");
		
		cacheService.addToCache(cachedUserTest);
		
		assertEquals("User " + cachedUserTest + " should be in the cache", true, testCache.contains(cachedUserTest));
	}

}
