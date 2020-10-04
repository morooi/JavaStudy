/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:58 CST
 */

package com.morooi.interfaceDemo.extendsDemo;

public interface MyInterfaceExtendsB {
    // 错误写法！接口不能有静态代码块
//    static {
//
//    }

    // 错误写法！接口不能有构造方法
//    public MyInterfaceExtends() {
//
//    }
    public abstract void methodB();

    public default void methodDefault() {
        System.out.println("默认方法B");
    }
}
