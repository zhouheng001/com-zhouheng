package distributedlock;

import redis.clients.jedis.Jedis;

import java.net.URI;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-07-24 19:25
 */
public class TestCache {

    private static Jedis jedis;

    static {
        jedis = new Jedis();
    }

    public static void main(String[] args) {

    }

}