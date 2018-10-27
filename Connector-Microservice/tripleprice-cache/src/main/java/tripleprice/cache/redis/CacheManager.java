package tripleprice.cache.redis;

import tripleprice.cache.CacheChannel;

/**
 * 
 * @author ari.prasetito
 *
 */
public final class CacheManager {

	private final CacheChannel[] cacheChannelList;

	public CacheManager(CacheChannel[] cacheChannelList) {
		this.cacheChannelList = cacheChannelList;
	}

	public final CacheChannel getKey(String prefixCache) {
		for (CacheChannel cacheChannel : cacheChannelList) {
			return (cacheChannel.getPrefix() == prefixCache ? cacheChannel : null);
		}
		return null;
	}
}
