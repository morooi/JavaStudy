/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
* 创建线程的方式: 使用线程池
*
* 好处:
*   1. 提高响应速度(减少了创建新线程的时间)
*   2. 降低资源消耗(重复利用线程池中的线程, 不需要每次都创建)
*   3. 便于线程管理
* */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo13NewThreadPool {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

/*        // 线程的管理
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        service1.setCorePoolSize(15); // 设置核心池的大小
        service1.setMaximumPoolSize(5); // 设置最大线程数
        service1.setKeepAliveTime(); // 设置线程没有任务时最多保持多长时间后终止*/

        // 2. 执行指定的线程操作, 需要提供 Runnable 接口或 Callable 接口实现类的对象
        service.execute(new NumberThread1()); // 适合适用于 Runnable
        service.execute(new NumberThread2()); // 适合适用于 Runnable

//        service.submit(); // 适合适用于 Callable

        // 3. 关闭线程池
        service.shutdown();
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}