package cn.morooi.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    private static JedisPool jedisPool = null;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        String host = rb.getString("redis.host");
        String port = rb.getString("redis.port");
        String maxTotal = rb.getString("redis.maxTotal");
        String maxIdel = rb.getString("redis.maxIdel");

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdel));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPool = new JedisPool(jedisPoolConfig, host, Integer.parseInt(port));
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
