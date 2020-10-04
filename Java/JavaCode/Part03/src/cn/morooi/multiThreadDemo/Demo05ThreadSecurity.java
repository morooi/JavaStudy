/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 例子: 创建三个窗口卖票, 总票数为 100 张
 *
 * 在 Java 中, 通过同步机制, 来解决线程的安全问题
 * 说明: 1. 操作共享数据的代码, 即为需要被同步的代码  --> 不能包含代码多了, 也不能包含代码少了
 *      2. 共享数据: 多个线程共同操作的变量
 *      3. 同步监视器, 俗称: 锁. 任何一个类的对象, 都可以充当锁
 *         要求: 多个线程必须要共用同一把锁
 *
 * 方式一: 同步代码块
 *   synchronized(同步监视器) {
 *       // 需要被同步的代码
 *   }
 *   总结: 在实现 Runnable 接口创建多线程的方式中, 可以考虑使用 this 充当同步监视器
 *        在继承 Thread 类创建多线程的方式中, 慎用 this 充当同步监视器, 考虑使用当前类充当同步监视器
 *
 * 方式二: 同步方法 (如果操作共享数据的代码完整的声明在一个方法中, 我们不妨将此方法声明为同步的)
 *   总结: 1. 同步方法仍然涉及到同步监视器, 只是不需要我们显式的声明
 *        2. 非静态的同步方法, 同步监视器是: this
 *           静态的同步方法, 同步监视器是: 当前类本身
 *
 * 同步的方式
 *   1. 解决了线程的安全问题
 *   2. 操作同步代码时, 只能有一个线程参与, 其他线程等待, 相当于是单线程, 效率低
 * */

// 实现 Runnable 接口, 同步代码块
public class Demo05ThreadSecurity {
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

class Window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) { // 使用 this, 表示当前对象, 唯一的 Window1 对象
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
            }
        }
    }
}
