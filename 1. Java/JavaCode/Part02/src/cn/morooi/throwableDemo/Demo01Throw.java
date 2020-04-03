/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 17:54 CST
 */

package cn.morooi.throwableDemo;

/*
 * throw 关键字
 * 作用:
 *   可以使用 throw 关键字在指定的方法中抛出指定的异常
 * 使用格式:
 *   throw new xxxException("异常参数的原因");
 * 注意:
 *   1. throw 关键字必须写在方法的内部
 *   2. throw 关键字后边 new 的对象必须是 Exception 或 Exception 的子类
 *   3. throw 关键字抛出指定的异常对象, 我们就必须处理这个异常对象 (throws 或 try...catch)
 *       如果 throw 关键字后边创建的是 RuntimeException 或者是 RuntimeException 的子类对象,
 *       我们可以不处理, 默认交给 JVM 处理 (打印异常对象, 中断程序)
 *
 * */

import java.util.Objects;

public class Demo01Throw {
    public static void main(String[] args) {
        int[] arrays = new int[3];
        int element = getElement(arrays, 3);
        System.out.println(element);

        System.out.println("后续程序");
    }

    /*
     * 定义一个方法, 必须首先对方法传递过来的参数进行合法性校验
     * 如果参数不合法, 就必须使用抛出异常的方式, 告知方法的调用者, 传递的参数有问题
     * */
    public static int getElement(int[] arr, int index) {
        if (arr == null) {
            // NullPointerException 是一个运行期异常 (RuntimeException), 默认交给 JVM 处理
            throw new NullPointerException("传递的参数为空");
        }

        // 或使用 Objects.requireNonNull
        Objects.requireNonNull(arr);
        Objects.requireNonNull(arr, "传递的参数为空");

        if (arr.length <= index || index < 0) {
            // IndexOutOfBoundsException 是一个运行期异常 (RuntimeException), 默认交给 JVM 处理
            throw new IndexOutOfBoundsException("超出索引范围");
        }

        return arr[index];
    }
}
