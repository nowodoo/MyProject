package com.zach.redis.common;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * Created by zach on 17/6/7.
 */
public class TestCase {
    private JedisPool pool = new JedisPool(new JedisPoolConfig(), RedisConfig.url);
    private Jedis jedis = pool.getResource();

    @Test
    public void test() {
        /// ... do stuff here ... for example
        jedis.set("foo", "bar");
        String foobar = jedis.get("foo");
        jedis.zadd("sose", 0, "car"); jedis.zadd("sose", 0, "bike");
        Set<String> sose = jedis.zrange("sose", 0, -1);

        pool.destroy();
    }

    @Test
    public void testList() {
        jedis.lpush("list", "a");
        jedis.lpush("list", "b");
        jedis.lpush("list", "c");
        jedis.lpush("list", "d");

        List<String> list = jedis.lrange("list", 0, -1);

        pool.destroy();
    }
}
