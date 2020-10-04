/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 23:40 CST
 */

package com.morooi.interfaceDemo.privateDemo;

/*
 * 问题描述：
 * 我们需要抽取一个共有方法，用来解决两个默认方法之间重复代码的问题
 * 但是这个共有方法不应该让实现类使用，应该是私有化的
 *
 * 解决方案：
 * 从Java 9开始，接口中允许定义私有方法
 * 1、普通私有方法，解决多个默认方法之间重复代码问题
 *  格式：
 *  private 返回值类型 方法名称(参数列表) {
 *      // 方法体
 *  }
 *
 * 2、静态私有方法，解决多个静态方法之间重复代码问题
 *  格式：
 *  private static 返回值类型 方法名称(参数列表) {
 *      // 方法体
 *  }
 *
 * */

public class MyInterface {
    public static void main(String[] args) {
        MyInterfacePrivateImplA c = new MyInterfacePrivateImplA();
        c.methodA();
        c.methodB();
    }
}
