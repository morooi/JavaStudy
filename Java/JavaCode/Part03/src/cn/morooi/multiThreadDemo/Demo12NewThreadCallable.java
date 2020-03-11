/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/*
 * 创建线程的方式三: 实现 Callable 接口.  --- JDK 5.0 新增
 *
 * 如何理解实现 Callable 接口尝试创建多线程比实现 Runnable 接口创建多线程方式强大?
 *   1. call() 可以有返回值
 *   2. call() 可以抛出异常, 被外面的操作捕获, 获取异常的信息
 *   3. Callable 是支持泛型的
 * */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo12NewThreadCallable {
    public static void main(String[] args) {
        // 3. 创建 Callable 接口实现类的对象
        NumThread numThread = new NumThread();
        // 4. 将此 Callable 接口实现类的对象作为参数传递到 FutureTask 的构造器中, 创建 FutureTask 的对象
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);
        // 5. 将 FutureTask 的对象作为参数传递到 Thread 类的构造器中, 创建 Thread 对象, 并调用 start()
        new Thread(futureTask).start();

        try {
            // 6. 获取 Callable 中 call 方法的返回值
            // get() 返回值即为 FutureTask 构造器参数 Callable 实现类重写的 call() 的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为: " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


// 1. 创建一个实现 Callable 接口的实现类
class NumThread implements Callable<Integer> {

    // 2. 实现 call 方法, 将此线程需要执行的操作声明在 call() 中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += 1;
            }
        }
        return sum;
    }
}