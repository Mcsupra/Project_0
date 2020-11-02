package MoneyAppServices;

import java.util.HashSet;
import java.util.Set;




public class UserCacheServiceSIM<T> implements UserCacheService<T> {
	
	private Set<T> cache = new HashSet<T>();
	
	public UserCacheServiceSIM(Set<T> cache) {
		super();
		this.cache = cache;
	}
	
	
	
	public Set<T> getCache() {
		return cache;
	}



	public void setCache(Set<T> cache) {
		this.cache = cache;
	}



	@Override
	public void addToCache(T obj) {
		//Adds an obj to the cache of which ever type
		cache.add(obj);
		
	}

	@Override
	public void remFromCache(T obj) {
		// TODO Remove an item from the cache
		//		cache.remove(obj) and then check to see the obj still exists
		
	}

	@Override
	public T retrieveItemFromCache(String username) {
		// TODO given a username return the object associated with it
		//		Check set to see it user != null
		
		return null;
	}


	/*@Override
	public void updateFromCache(String field) {
		// TODO Implement code to change certain fields of object T
		//		.getEmail = .setEmail for example
	}*/

	 
}
