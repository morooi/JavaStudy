/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 线程通信的例子: 使用两个线程打印 1-100. 线程1, 线程2 交替打印
 *
 * 涉及到的三个方法:
 *   wait(): 一旦执行此方法, 当前线程就进入阻塞状态, 并释放同步监视器
 *   notify(): 一旦执行此方法, 就会唤醒被 wait 的一个线程. 如果有多个线程被 wait, 就唤醒优先级高的
 *   notifyAll(): 一旦执行此方法, 就会唤醒所有被 wait 的线程
 *
 * 说明:
 *   1. wait(), notify(), notifyAll() 三个方法必须使用在同步代码块或同步方法中
 *   2. wait(), notify(), notifyAll() 三个方法的调用者必须是同步代码块或同步方法中的同步监视器, 否则会出现异常
 *   3. wait(), notify(), notifyAll() 三个方法是定义在 java.lang.Object 类中的
 *
 *
 * 面试题: sleep() 和 wait() 的异同?
 *   相同点: 一旦执行方法, 都可以使当前线程进入阻塞状态
 *   不同点: 1. 两个方法声明的位置不同: Thread 类中声明 sleep(), Object 类中声明 wait()
 *          2. 调用的要求不同: sleep() 可以在任何需要的场景下使用, wait() 必须使用在同步代码块或同步方法中
 *          3. 关于是否释放同步监视器: 如果两个方法都使用在同步代码块或同步方法中, sleep() 不会释放锁, wait() 会释放锁
 * */

public class Demo11ThreadCommunication {
    public static void main(String[] args) {
        Number number = new Number();

        Thread thread1 = new Thread(number, "线程1");
        Thread thread2 = new Thread(number, "线程2");

        thread1.start();
        thread2.start();
    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}