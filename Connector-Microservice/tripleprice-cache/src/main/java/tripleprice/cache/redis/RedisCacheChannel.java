package tripleprice.cache.redis;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import tripleprice.cache.CacheChannel;

/**
 * '
 * 
 * @author ari.prasetiyo
 *
 */
public class RedisCacheChannel implements CacheChannel {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheChannel.class);

	@Autowired
	@Qualifier("redisTemplateString")
	private RedisTemplate<String, String> redisTemplateString;

	private final short expiry;
	private final String prefixKey;

	public RedisCacheChannel(final String prefixKey,final short expiry) {
		this.expiry = expiry;
		this.prefixKey = prefixKey;
		LOGGER.info("Start redisCacheChannel prefixKey={}, expiry={}", prefixKey, expiry);
	}

	@Override
	public String getPrefix() {
		return this.prefixKey;
	}

	@Override
	public void load(final String key, final String value) {

		if (key == null || this.prefixKey == null)
			return;

		LOGGER.debug("Load cache key={}{}", this.prefixKey, key);
		if (expiry > 1) {
			redisTemplateString.opsForValue().set(this.prefixKey + key, value, expiry, TimeUnit.SECONDS);
		} else {
			redisTemplateString.opsForValue().set(this.prefixKey + key, value);
		}
	}

	@Override
	public boolean remove(final String key) {
		if (key == null || this.prefixKey == null)
			return false;

		LOGGER.debug("Remove cache key={}{}", this.prefixKey, key);
		return redisTemplateString.delete(this.prefixKey + key);
	}

	@Override
	public String lookup(final String key) {
		if (key == null || this.prefixKey == null)
			return null;

		LOGGER.debug("Lookup cache key={}{}", this.prefixKey, key);
		return redisTemplateString.opsForValue().get(this.prefixKey + key);
	}
}
