/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 多线程的创建
 *
 * 方式一: 继承于 Thread 类
 *   1. 创建一个继承于 Thread 类的子类
 *   2. 重写 Thread 类的 run()
 *   3. 创建 Thread 类的子类对象
 *   4. 通过此对象调用 start()
 *      例子: 遍历 100 以内的所有偶数
 *
 * 方式二: 实现 Runnable 接口
 *   1. 创建一个实现了 Runnable 接口的类
 *   2. 重写 Thread 类的 run() --> 将此线程执行的操作声明在 run() 中
 *   3. 创建实现类的对象
 *   4. 将此对象作为参数传递到 Thread 类的构造器中, 创建 Thread 类的对象
 *   5. 通过 Thread 类的对象调用 strat()
 *      例子: 遍历 100 以内的所有偶数
 *
 * 比较:
 *   开发中优先使用方式二
 *      原因: 1. 方式二没有类的单继承性的局限性
 *           2. 方式二更适合来处理多个线程有共享数据的情况
 *   联系: public class Thread implements Runnable
 *   相同点: 两种方式都需要重写 run(), 将线程要执行的逻辑声明在 run() 中
 */


public class Demo01NewThread {
    public static void main(String[] args) {
        // 1.3. 创建 Thread 类的子类对象
        MyThread myThread = new MyThread();
        // 1.4. 通过此对象调用 start(): 启动当前线程, 调用当前线程的 run()
        myThread.start();

        // 问题二: 再启用一个线程, 遍历 100 以内的偶数
//        myThread.start(); // 不可以还让已经 start 的线程去执行
        MyThread myThread2 = new MyThread(); // 重新创新的线程
        myThread2.start();

        // 2.3 创建实现类的对象
        MThread mThread = new MThread();
        // 2.4 将此对象作为参数传递到 Thread 类的构造器中, 创建 Thread 类的对象
        Thread thread = new Thread(mThread);
        thread.start();


        // 如下操作仍然是在 main 线程中执行的
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": hello" + i);
        }
    }
}


// 1.1. 创建一个继承于 Thread 类的子类
class MyThread extends Thread {
    // 1.2. 重写 Thread 类的 run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

    }
}

// 2.1. 创建一个实现了 Runnable 接口的类
class MThread implements Runnable {
    // 2.2 重写 Thread 类的 run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
