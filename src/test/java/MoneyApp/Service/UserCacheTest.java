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
	private User testUser1;
	private User testUser2;
	private User testUser3;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testCache = new HashSet<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		testUser1 = new User("Michael Zide", "Mzide", "rEaLlYcLeVeR", "myemail24@gmail.com", "1234567890");
		testUser2 = new User("Patrick Robertson", "bmxer4life", "HelloWorldhehe!!", "bmxer4life@hotmail.com", "(465)113-1656");
		testUser3 = new User("Николас Юрчак", "Николас", "Николас Юрчак", "Николас Юрчак@НиколасЮрчак.net", "5553223");
		
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
		
		assertTrue("User " + cachedUserTest + " should be in the cache", testCache.contains(cachedUserTest));
	}
	
	@Test
	public void retrieveItemFromCacheTest() {
		
		String testUsername = testUser1.getUsername();
		
		User retrievedUser =  cacheService.retrieveItemFromCache(testUsername);
		
		assertEquals("If username exists in cache, return true",true, testUser1.equals(retrievedUser));
	}
	
	@Test
	public void remFromCacheTes() {
		
		testCache.remove(testUser1);
		cacheService.remFromCache(testUser1);
		
		assertEquals("If user is removed, return true",true, testCache.equals(cacheService));
		
	}

}
