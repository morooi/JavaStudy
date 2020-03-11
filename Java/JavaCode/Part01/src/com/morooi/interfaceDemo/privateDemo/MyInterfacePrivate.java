/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:22 CST
 */

package com.morooi.interfaceDemo.privateDemo;

public interface MyInterfacePrivate {
    default void methodA() {
        System.out.println("默认方法A");
        methodCommon();
    }

    default void methodB() {
        System.out.println("默认方法B");
        methodCommon();
    }

    // 使用private关键字
    private void methodCommon() {
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }
}
