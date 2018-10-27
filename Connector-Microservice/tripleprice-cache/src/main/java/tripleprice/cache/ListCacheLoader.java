package tripleprice.cache;

import java.util.List;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public interface ListCacheLoader {
	
	public int load(final String key, final List<Object> value);

	public int loadAll();
	
	public int remove(final String key);

	public int removeAll();
}
