package com.qiyun.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	private static Logger log = LoggerFactory.getLogger(RedisUtil.class);
	// Redis服务器IP
//	private static final String ADDR = "120.27.214.112";
	private static final String ADDR = "47.96.179.183";
	// Redis的端口号
	private static final int PORT = 6011;
	// 访问密码
	private static final String AUTH = "bR@hl#2cmxYA";
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = 1024;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;
	private static int TIMEOUT = 10000;
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;
	private static JedisPool jedisPool = null;
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);//高版本更名
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);//高版本更名
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT,AUTH);
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
	
//	public static void returnResource(final Jedis jedis) {
//		if(jedis != null) {
//			jedisPool.returnResource(jedis);
//		}
//	}
	
	// redis服务地址
	// private static final String host = "47.96.179.183";
	//// private static final String host = "120.27.214.112";
	// //redis服务端口
	// private static final int port = 6379;
	// //连接redis的超时时间
	//// private int timeout;
	//
	// public static Jedis getRedis() {
	// Jedis jedis = new Jedis(host, port);
	// return jedis;
	// }
}
