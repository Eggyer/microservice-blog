package com.clsaa.blog.gateway.zuul.util.redis;


import com.clsaa.blog.gateway.zuul.util.spring.SpringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*@Component*/
public class RedisService {
/*    @Autowired*/
/*    private JedisPool jedisPool;
    public RedisService() {
        jedisPool = SpringUtils.getApplicationContext().getBean(JedisPool.class);
    }*/

    public static String setStr(String key, String value){
        JedisPool jedisPool = SpringUtils.getApplicationContext().getBean(JedisPool.class);
        Jedis jedis = jedisPool.getResource();
        String code = jedis.set(key,value);
        jedis.close();
        return code;
    }

    public static String getStr(String key){
        JedisPool jedisPool = SpringUtils.getApplicationContext().getBean(JedisPool.class);
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }


}
