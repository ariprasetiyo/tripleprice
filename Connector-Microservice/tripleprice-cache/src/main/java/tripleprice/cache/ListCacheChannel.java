package tripleprice.cache;

import java.util.List;

import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TShortArrayList;

/**
 * @author ari.prasetiyo
 */
public interface ListCacheChannel {

	public int load(final String key, final TDoubleArrayList value);
	
	public int load(final String key, final TFloatArrayList value);
	
	public int load(final String key, final TIntArrayList value);
	
	public int load(final String key, final TShortArrayList value);
	
	public int load(final String key, final List<String> value);
	
	public int remove(final String key);
	
	public Object lookup(final String key);
}
