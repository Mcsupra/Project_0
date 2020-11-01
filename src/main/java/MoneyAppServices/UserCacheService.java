package MoneyAppServices;


public interface UserCacheService <T> {
	
	public void addToCache(T obj);
	
	public void remFromCache(T obj);
	
	public T retrieveItemFromCache(T obj);
	
	public boolean contains(T obj);
	
	public void updateFromCache(T org,T upd);
	

}
