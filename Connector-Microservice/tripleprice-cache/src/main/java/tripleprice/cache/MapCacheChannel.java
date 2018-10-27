package tripleprice.cache;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public interface MapCacheChannel {
	
	public int load(final String key, final Map<Integer, String> value);

	public int remove(final String key);
	
	public List<Object> lookup(final String key);
}
