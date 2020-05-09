package com.qiyun.httpUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

@Component
public class RedisUtil {
	private static Logger log = LoggerFactory.getLogger(RedisUtil.class);
	private static JedisPool jedisPool = null;

	static {
		Properties prop = new Properties();
		InputStream in = RedisUtil.class.getClassLoader().getResourceAsStream("redisUtil.properties");
		try {
			prop.load(in);
			String addr = prop.getProperty("redis.addr").trim();
			int port = Integer.parseInt(prop.getProperty("redis.port").trim());
			String auth = prop.getProperty("redis.auth").trim();
			int maxActive = Integer.parseInt(prop.getProperty("redis.maxActive").trim());
			int maxIdle = Integer.parseInt(prop.getProperty("redis.maxIdle").trim());
			int maxWait = Integer.parseInt(prop.getProperty("redis.maxWait").trim());
			int timeOut = Integer.parseInt(prop.getProperty("redis.timeOut").trim());
			boolean testOnBorrow = Boolean.parseBoolean(prop.getProperty("redis.testOnBorrow").trim());
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(maxActive);//高版本更名
			config.setMaxIdle(maxIdle);
			config.setMaxWaitMillis(maxWait);//高版本更名
			config.setTestOnBorrow(testOnBorrow);
			jedisPool = new JedisPool(config, addr, port, timeOut,auth);
		} catch (Exception e) {
			log.error("-------------e",e);
		}
	}

	/**
	 * 获取Jedis实例
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if(jedisPool != null) {
				Jedis jedis = jedisPool.getResource();
				return jedis;
			} else {
				log.error("----------------jedisPool" + jedisPool);
				return null;
			}
		} catch (Exception e) {
			log.error("-------------e",e);
			return null;
		}
	}

//	public static void main(String[] args) {
//		Jedis jedis = RedisUtil.getJedis();
//		jedis.set("test","测试");
//		System.out.println(jedis.get("test"));
//	}

}
