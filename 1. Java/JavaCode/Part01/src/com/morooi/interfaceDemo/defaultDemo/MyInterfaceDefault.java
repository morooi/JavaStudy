/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:01 CST
 */

package com.morooi.interfaceDemo.defaultDemo;

public interface MyInterfaceDefault {
    public abstract void method01();

    public default void method02() {
        System.out.println("这是新添加的默认方法");
    }
}
