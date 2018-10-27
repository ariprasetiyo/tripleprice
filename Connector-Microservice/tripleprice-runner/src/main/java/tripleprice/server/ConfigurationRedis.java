package tripleprice.server;

import java.time.Duration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import gnu.trove.list.array.TDoubleArrayList;
import gnu.trove.list.array.TFloatArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.array.TShortArrayList;

/**
 * 
 * @author ari.prasetiyo
 *
 */
@Configuration
@Component
public class ConfigurationRedis {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationRedis.class);

	@Value("${redis.master0.hostname}")
	private String redisHostName;

	@Value("${redis.master0.port}")
	private short redisPort;

	private static final boolean ENABLE_TRANSACTIONAL_CACHE = true;

	/*
	 * private JedisPoolConfig buildPoolConfig() { final JedisPoolConfig
	 * poolConfig = new JedisPoolConfig(); poolConfig.setMaxTotal(128);
	 * poolConfig.setMaxIdle(128); poolConfig.setMinIdle(16);
	 * poolConfig.setTestOnBorrow(true); poolConfig.setTestOnReturn(true);
	 * poolConfig.setTestWhileIdle(true);
	 * poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis(
	 * )); poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).
	 * toMillis()); poolConfig.setNumTestsPerEvictionRun(3);
	 * poolConfig.setBlockWhenExhausted(true); return poolConfig; }
	 */

	/**
	 * @doc:LettuceConnectionFactory
	 * @site:https://www.concretepage.com/spring-boot/spring-boot-redis-cache
	 * @doc:JedisConnectionFactory
	 * @site:https://www.concretepage.com/spring-4/spring-data-redis-example
	 * @return
	 */
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		final RedisStandaloneConfiguration redisStandAlone = new RedisStandaloneConfiguration();
		redisStandAlone.setHostName(redisHostName);
		redisStandAlone.setPort(redisPort);
		final JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
		jedisClientConfiguration.connectTimeout(Duration.ofSeconds(60)).usePooling();
		LOGGER.info("Start jedisConnectionFactory host={}:{}", redisHostName, redisPort);
		return new JedisConnectionFactory(redisStandAlone, jedisClientConfiguration.build());
	}

	@Bean(name = "redisTemplateString")
	public RedisTemplate<String, String> redisTemplateString() {
		final RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());

		/*
		 * redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		 * redisTemplate.setKeySerializer(new StringRedisSerializer());
		 * redisTemplate.setValueSerializer(new StringRedisSerializer());
		 * redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		 */
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, TDoubleArrayList> redisTemplateTDoubleArrayList() {
		final RedisTemplate<String, TDoubleArrayList> redisTemplate = new RedisTemplate<String, TDoubleArrayList>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, TFloatArrayList> redisTemplateTFloatArrayList() {
		final RedisTemplate<String, TFloatArrayList> redisTemplate = new RedisTemplate<String, TFloatArrayList>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, TShortArrayList> redisTemplateTShortArrayList() {
		final RedisTemplate<String, TShortArrayList> redisTemplate = new RedisTemplate<String, TShortArrayList>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, TIntArrayList> redisTemplateTIntArrayList() {
		final RedisTemplate<String, TIntArrayList> redisTemplate = new RedisTemplate<String, TIntArrayList>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, List<String>> redisTemplateStringArryList() {
		final RedisTemplate<String, List<String>> redisTemplate = new RedisTemplate<String, List<String>>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(ENABLE_TRANSACTIONAL_CACHE);
		return redisTemplate;
	}

	/**
	 * Disable caching {@literal null} values. <br />
	 * <strong>NOTE</strong> any
	 * {@link org.springframework.cache.Cache#put(Object, Object)} operation
	 * involving {@literal null} value will error. Nothing will be written to
	 * Redis, nothing will be removed. An already existing key will still be
	 * there afterwards with the very same value as before.
	 */

	/**
	 * Set the ttl to apply for cache entries. Use {@link Duration#ZERO} to
	 * declare an eternal cache.
	 */
	/*
	 * @Bean public RedisCacheConfiguration cacheConfiguration() {
	 * RedisCacheConfiguration cacheConfig =
	 * RedisCacheConfiguration.defaultCacheConfig()
	 * .entryTtl(Duration.ofSeconds(600)).disableCachingNullValues().
	 * prefixKeysWith("hallo");
	 * System.out.println("\n\n\n\n\n\n\n\n\n"+cacheConfig.getKeyPrefix()
	 * +cacheConfig.getTtl());
	 * 
	 * return cacheConfig; }
	 */

	/**
	 * transactionAware() : Enable {@link RedisCache}s to synchronize cache
	 * put/evict operations with ongoing Spring-managed transactions.
	 */
	/*
	 * @Bean public RedisCacheManager cacheManager() { RedisCacheManager rcm =
	 * RedisCacheManager.builder(jedisConnectionFactory()).cacheDefaults(
	 * cacheConfiguration()) .transactionAware().build();
	 * 
	 * return rcm; }
	 */
}
