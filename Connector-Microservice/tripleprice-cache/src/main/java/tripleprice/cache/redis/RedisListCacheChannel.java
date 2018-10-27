package tripleprice.cache.redis;

import java.util.List;

import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TShortArrayList;
import tripleprice.cache.ListCacheChannel;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public class RedisListCacheChannel implements ListCacheChannel {

	@Override
	public int load(String key, TDoubleArrayList value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int load(String key, TFloatArrayList value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int load(String key, TIntArrayList value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int load(String key, TShortArrayList value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int load(String key, List<String> value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object lookup(String key) {
		// TODO Auto-generated method stub
		return null;
	}



}
