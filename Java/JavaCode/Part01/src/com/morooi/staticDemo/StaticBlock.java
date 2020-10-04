/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 14:58 CST
 */

package com.morooi.staticDemo;

/*
 * 静态代码块的格式：
 *
 * public class 类名称 {
 *     static {
 *         // 静态代码块的内容
 *     }
 * }
 *
 * 特点：当第一次用到本类时，静态代码块执行唯一的一次
 * 静态内容总是优先于非静态，所以静态代码块比构造方法先执行
 *
 * 静态代码块的典型用途：
 *    用来一次性地对静态成员变量进行赋值
 * */

public class StaticBlock {
    public static void main(String[] args) {
        Demo one = new Demo();
        Demo two = new Demo(); // 不执行静态代码块
    }
}


class Demo {
    static {
        System.out.println("静态代码块执行！");
    }

    public Demo() {
        System.out.println("构造方法执行！");
    }
}