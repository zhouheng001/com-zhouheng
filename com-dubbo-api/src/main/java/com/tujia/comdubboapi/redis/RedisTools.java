package com.tujia.comdubboapi.redis;

import redis.clients.jedis.Jedis;

/**
 * 描述:
 * 测试redis
 *
 * @author zhouheng
 * @create 2019-07-24 19:16
 */
public class RedisTools {

    public static boolean set(Jedis jedis,String key,String value){
        String set = jedis.set(key, value);
        return false;
    }

    public static String get(Jedis jedis,String key){
        String result = jedis.get(key);
        return result;
    }

    public static String hget(Jedis jedis,String key,String field){
        String result = jedis.hget(key,field);
        return result;
    }
    public static long hset(Jedis jedis,String key,String field,String value){
        Long result = jedis.hset(key, field, value);
        return result;
    }



}