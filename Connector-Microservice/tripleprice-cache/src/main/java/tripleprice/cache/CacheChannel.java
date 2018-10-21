package tripleprice.cache;

public interface CacheChannel {
	
	public int load(String key);
	public int loadAll();
	public int clear(String key);
	public int clearAll();
}
