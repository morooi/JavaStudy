package cn.morooi;

import cn.morooi.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.Random;

public class Service {
    private String userId;

    public Service(String userId) {
        this.userId = userId;
    }

    // 控制单元
    public void service() {
//        try (Jedis jedis = new Jedis("192.168.66.6")) {
        try (Jedis jedis = JedisUtils.getJedis()) {
            if ("VIP用户".equals(userId)) {
                if (jedis.get("compid:" + userId) == null) {
                    // 不存在，则设置
                    jedis.setex("compid:" + userId, 20, String.valueOf(0));
                }
                // 自增，同时调用业务
                business(userId, jedis.incr("compid:" + userId));
            } else {
                long num = Long.parseLong(jedis.hget("权限次数", userId));

                if (jedis.get("compid:" + userId) == null) {
                    // 不存在，则设置
                    jedis.setex("compid:" + userId, 20, String.valueOf(Long.MAX_VALUE - num));
                }
                // 自增，同时调用业务
                business(userId, num - (Long.MAX_VALUE - jedis.incr("compid:" + userId)));
            }
        } catch (Exception e) {
            System.out.println("用户：" + userId + "使用已经到达上限");
        }
    }

    // 业务操作
    public void business(String id, Long count) {
        System.out.println("业务操作执行，用户：" + id + "，调用" + count + "次");
    }
}

class MyThread extends Thread {
    Service sc;

    public MyThread(String userId) {
        sc = new Service(userId);
    }

    public void run() {
        while (true) {
            sc.service();
            Random random = new Random();
            try {
                Thread.sleep(500L + random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("初级用户");
        MyThread thread2 = new MyThread("高级用户");
        MyThread thread3 = new MyThread("VIP用户");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
