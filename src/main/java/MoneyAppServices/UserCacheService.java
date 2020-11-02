package MoneyAppServices;


public interface UserCacheService <T> {
	
	public void addToCache(T obj);
	
	public void remFromCache(T obj);
	
	public T retrieveItemFromCache(String username);
	
	//public void updateFromCache(String field);
	

}
