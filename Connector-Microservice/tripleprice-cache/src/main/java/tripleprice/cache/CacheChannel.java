package tripleprice.cache;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public interface CacheChannel {

	public String getPrefix();
	
	public void load(final String key, final String value);

	public boolean remove(final String key);

	public String lookup(final String key);
}
