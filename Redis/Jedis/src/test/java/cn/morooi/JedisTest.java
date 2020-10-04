package cn.morooi;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void testJedis() {
        // 1. 连接 Jedis
        Jedis jedis = new Jedis("192.168.66.6", 6379);
        // 2. 操作 Jedis
//        jedis.set("name", "zsj");
        jedis.del("name");
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testList() {
        // 1. 连接 Jedis
        Jedis jedis = new Jedis("192.168.66.6", 6379);
        // 2. 操作 Jedis
        jedis.lpush("list01", "1", "2", "3");
        jedis.rpush("list01", "a", "b", "c");

        List<String> list01 = jedis.lrange("list01", 0, -1);
        System.out.println(list01);
        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void testHash() {
        // 1. 连接 Jedis
        Jedis jedis = new Jedis("192.168.66.6", 6379);
        // 2. 操作 Jedis
        jedis.hset("hash1", "a1", "1");
        jedis.hset("hash1", "a2", "2");
        jedis.hset("hash1", "a3", "3");

        Map<String, String> hash1 = jedis.hgetAll("hash1");
        System.out.println(hash1);
        Set<Map.Entry<String, String>> entries = hash1.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(hash1.get(entry.getKey()));
        }
        System.out.println("len = " + jedis.hlen("hash1"));

        // 3. 关闭连接
        jedis.close();
    }

    @Test
    public void test() {
        // 1. 连接 Jedis
        Jedis jedis = new Jedis("192.168.66.6", 6379);
        // 2. 操作 Jedis
        jedis.hset("权限次数", "初级用户", "10");
        jedis.hset("权限次数", "高级用户", "30");
        // 3. 关闭连接
        jedis.close();
    }
}
