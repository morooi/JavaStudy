/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 21:02 CST
 */

package cn.morooi.throwableDemo;

/*
 * try...catch: 异常处理的第二种方式, 自己处理异常
 *
 * 格式:
 *   try{
 *       可能产生异常的代码
 *   } catch(定义一个异常的变量, 用来接收 try 中抛出的异常对象) {
 *       异常的处理逻辑, 产生异常对象之后怎么处理异常对象(一般会记录到日志中)
 *   } catch(异常类名 变量名) {
 *       ... // 可以有多个
 *   }
 *
 * 注意:
 *   1. try 中可能抛出多个异常对象, 那么就可以使用多个 catch 来处理这些异常对象
 *   2. 如果 try 中产生了异常, 就会执行 catch 中的异常处理逻辑, 执行完毕 catch 中的处理逻辑, 继续执行之后的代码
 *      如果 try 中没有产生异常, 执行完 try 中的代码, 继续执行 try...catch 之后的代码
 * */

import java.io.FileNotFoundException;

public class Demo03TryCatch {
    public static void main(String[] args) {
        try {
            readFile("~/1.xt");
        } catch (FileNotFoundException e) { // try 中抛出什么异常对象, catch就定义什么异常变量, 用来接收这个异常
            /*
             * Thorwable 类中定义了 3 个异常处理的方法
             *   String getMessage(): 返回此 throwable 的简短描述
             *   String toString(): 返回此 throwable 的详细信息字符串
             *   void printStackTrace(): JVM 打印异常对象, 默认此方法, 异常信息最全面
             * */
            System.out.println(e.getMessage()); // 文件名不对
            System.out.println(e.toString()); // java.io.FileNotFoundException: 文件名不对
            e.printStackTrace();
        }

        System.out.println("后续代码");

    }

    public static void readFile(String fileName) throws FileNotFoundException {
        if (!"~/1.txt".equals(fileName)) {
            throw new FileNotFoundException("文件名不对");
        }
        System.out.println("没有问题");

    }
}


