package tripleprice.cache;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public interface CacheLoader {
	
	public int load(final String key, final String value);

	public int loadAll();

	public int remove(final String key);

	public int removeAll();
}
