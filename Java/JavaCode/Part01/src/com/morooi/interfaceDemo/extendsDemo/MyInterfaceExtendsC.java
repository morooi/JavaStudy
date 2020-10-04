/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:59 CST
 */

package com.morooi.interfaceDemo.extendsDemo;

public interface MyInterfaceExtendsC {
    public default void method() {
        System.out.println("接口方法");
    }
}
