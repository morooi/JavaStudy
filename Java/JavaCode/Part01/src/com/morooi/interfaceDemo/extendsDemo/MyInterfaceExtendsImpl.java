/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:55 CST
 */

package com.morooi.interfaceDemo.extendsDemo;

public class MyInterfaceExtendsImpl implements MyInterfaceExtendsA, MyInterfaceExtendsB {
    @Override
    public void methodA() {
        System.out.println("覆盖重写了A中的抽象方法");
    }

    @Override
    public void methodB() {
        System.out.println("覆盖重写了B中的抽象方法");
    }

    @Override
    public void methodDefault() {
        System.out.println("覆盖重写了两个接口中重名的默认方法");
    }
}
