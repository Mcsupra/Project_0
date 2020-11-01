package MoneyAppServices;

import java.util.HashSet;
import java.util.Set;




public class UserCacheServiceSIM<T> implements UserCacheService<T> {
	
	private Set<T> cache = new HashSet<T>();
	
	public UserCacheServiceSIM(Set<T> cache) {
		super();
		this.cache = cache;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Set<T> getCache() {
		return cache;
	}



	public void setCache(Set<T> cache) {
		this.cache = cache;
	}



	@Override
	public void addToCache(T obj) {
		
		cache.add(obj);
		
	}

	@Override
	public void remFromCache(T obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T retrieveItemFromCache(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateFromCache(T org, T upd) {
		// TODO Auto-generated method stub
		
	}

	 
}
