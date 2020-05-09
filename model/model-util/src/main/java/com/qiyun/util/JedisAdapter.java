package com.qiyun.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * 需要修改   不能正常使用
 */
@Service
public class JedisAdapter implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(JedisAdapter.class);

    private Jedis jedis = null;
    private JedisPool jedisPool = null;


    public void afterPropertiesSet() throws Exception {
        //初始化
        jedisPool = new JedisPool("47.97.192.124", 6011);
    }

    //获取一个Jedis
    private Jedis getJedis(){
        try{
            jedis =  jedisPool.getResource();
        }catch (Exception e){
            logger.error("获取jedis失败！" + e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return jedis;
    }

    /**
     * 获取Redis中集合中某个key值
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            return jedis.get(key);
        }catch (Exception e){
            logger.error("Jedis get发生异常 " + e.getMessage());
            return null;
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }

    /**
     * 给Redis中Set集合中某个key值设值
     * @param key
     * @param value
     */
    public void set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        }catch (Exception e){
            logger.error("Jedis set 异常" + e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }

    /**
     * 向Redis中Set集合添加值:点赞
     * @return
     */
    public long sadd(String key, String value){
        Jedis jedis = null;
        try{
            jedis =  jedisPool.getResource();
            return jedis.sadd(key, value);
        }catch (Exception e){
            logger.error("Jedis sadd 异常 ：" + e.getMessage());
            return 0;
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    /**
     * 移除：取消点赞
     * @param key
     * @param value
     * @return
     */
    public long srem(String key, String value){
        Jedis jedis = null;
        try{
            jedis =  jedisPool.getResource();
            return jedis.srem(key, value);
        }catch (Exception e){
            logger.error("Jedis srem 异常：" + e.getMessage());
            return 0;
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    /**
     *判断key,value是否是集合中值
     * @param key
     * @param value
     * @return
     */
    public boolean sismember(String key, String value){
        Jedis jedis = null;
        try{
            jedis =  jedisPool.getResource();
            return jedis.sismember(key, value);
        }catch (Exception e){
            logger.error("Jedis sismember 异常：" + e.getMessage());
            return false;
        }finally {
            if (jedis != null){
                try{
                    jedis.close();
                }catch (Exception e){
                    logger.error("Jedis关闭异常" + e.getMessage());
                }
            }
        }
    }

    /**
     * 获取集合大小
     * @param key
     * @return
     */
    public long scard(String key){
        Jedis jedis = null;
        try{
            jedis =  jedisPool.getResource();
            return jedis.scard(key);
        }catch (Exception e){
            logger.error("Jedis scard 异常：" + e.getMessage());
            return 0;
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

}