/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 线程的优先级:
 *   MAX_PRIORITY: 10
 *   MIN_PRIORITY: 1
 *   NORM_PRIORITY: 5  -- 默认的优先级
 *
 * 如何获取和设置当前线程的优先级:
 *   getPriority(): 获取线程的优先级
 *   setPriority(int p): 设置线程的优先级
 *
 * 说明: 高优先级的线程要抢占低优先级线程 CPU 的执行权. 但是只是从概率上讲, 高优先级的线程高概率的情况下被执行, 并不意味着只有当高优先级的线程
 *      执行完后再执行低优先级
 * */

public class Demo04ThreadPriority {
    public static void main(String[] args) {
        MyThread5 myThread = new MyThread5("Thread -- ");
        // 设定分线程的优先级
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
        }
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + getPriority() + ":" + i);
            }
        }
    }

    public MyThread5(String name) {
        super(name);
    }
}

