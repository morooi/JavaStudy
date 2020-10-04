/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 解决线程安全问题的方法三: Lock 锁 -- JDK 5.0 新增
 *
 * 1. 面试题: synchronized 与 Lock 的异同
 *      相同: 二者都可以解锁线程安全问题
 *      不同: synchronized 机制在执行完相应的同步代码后, 自动的释放同步监视器
 *           Lock 需要手动的启动同步(lock()), 同时结束时也需要手动的实现(unlock())
 *
 * 2. 优先使用顺序:
 *      Lock -> 同步代码块(已经进入了方法体, 分配了相应资源) -> 同步方法(在方法体之外)
 * */

import java.util.concurrent.locks.ReentrantLock;

public class Demo10ThreadSecurityLock {
    public static void main(String[] args) {
        Window5 window = new Window5();

        Thread w1 = new Thread(window, "窗口1");
        Thread w2 = new Thread(window, "窗口2");
        Thread w3 = new Thread(window, "窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window5 implements Runnable {

    private int ticket = 100;
    // 1. 实例化
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 2. 调用锁定方法: lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-卖票, 票号: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 3. 调用解锁方法: unlock()
                lock.unlock();
            }
        }
    }
}
