/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:56 CST
 */

package com.morooi.interfaceDemo.extendsDemo;

public abstract class MyInterfaceExtendsImplAbstract implements MyInterfaceExtendsA, MyInterfaceExtendsB {
    @Override
    public void methodA() {
        System.out.println("覆盖重写了A中的抽象方法，没有重写B中的抽象方法，是个抽象类");
    }

    @Override
    public void methodDefault() {
        System.out.println("覆盖重写了两个接口中重名的默认方法");
    }
}
