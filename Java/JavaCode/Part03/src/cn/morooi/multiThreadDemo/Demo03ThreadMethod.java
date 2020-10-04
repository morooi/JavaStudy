/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 测试 Thread 类中的常用方法
 * 1. start(): 启动当前线程, 调用当前线程的 run()
 * 2. run(): 通常需要重写 Thread 类中的此方法, 将创建的线程要执行的
 * 3. currentThread(): 静态方法, 返回执行当前代码的线程
 * 4. getName(): 获取当前线程的名字
 * 5. setName(): 设置当前线程的名字
 * 6. yield(): 释放当前 CPU 的执行权
 * 7. join(): 在线程 a 中调用线程 b 的 join(), 此时线程 a 就进入阻塞状态直到线程 b 完全执行完毕
 * 8. stop(): 已过时. 强制结束当前进程
 * 9. sleep(long millisecond): 让当前线程"睡眠"指定的 millisecond 毫秒, 在指定的 millisecond 毫秒时间内, 当前线程是阻塞状态
 * 10. isAlive(): 判断当前线程是否存活
 * */

public class Demo03ThreadMethod {
    public static void main(String[] args) {
        MyThread4 myThread = new MyThread4("线程一: ");
//        myThread.setName("线程一");
        myThread.start();

        // 给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20) {
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(myThread.isAlive()); // false
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(200); // 阻塞 200 毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

//            if (i % 20 == 0) {
//                yield();
//            }
        }
    }

    // 给线程命名方式二, 通过构造器的方式
    public MyThread4(String name) {
        super(name);
    }
}
