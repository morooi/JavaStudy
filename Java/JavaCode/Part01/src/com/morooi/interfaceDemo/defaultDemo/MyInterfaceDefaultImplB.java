/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:01 CST
 */

package com.morooi.interfaceDemo.defaultDemo;

public class MyInterfaceDefaultImplB implements MyInterfaceDefault {
    @Override
    public void method01() {
        System.out.println("实现了抽象方法B");
    }

    @Override
    public void method02() {
        System.out.println("实现类B覆盖重写了接口的默认方法");
    }
}
