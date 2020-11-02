package MoneyAppServices;

import java.util.HashMap;
import java.util.Map;





public class CacheServiceSIM<T> implements CacheService<T> {
	
	private Map<String, T> cache = new HashMap<String,T>();
	
	

	public CacheServiceSIM(Map<String,T> cache) {
		super();
		this.cache = cache;
	}
	

	public CacheServiceSIM() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Map<String, T> getCache() {
		return cache;
	}


	public void setCache(Map<String, T> cache) {
		this.cache = cache;
	}


	@Override
	public void addToCache(String key, T obj) {
		//Adds an obj to the cache of which ever type
		cache.put(key, obj);
	}


	@Override
	public T retrieveItemFromCache(String key) {
		
		if (cache.containsKey(key))
			return cache.get(key);
		else
			return null;		
	}




	/*@Override
	public void updateFromCache(String field) {
		// TODO Implement code to change certain fields of object T
		//		.getEmail = .setEmail for example
	}*/

	 
}
