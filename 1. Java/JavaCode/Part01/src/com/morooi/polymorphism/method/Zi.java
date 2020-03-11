/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 16:37 CST
 */

package com.morooi.polymorphism.method;

public class Zi extends Fu{

    int num = 20;
    int age = 30;

    @Override
    public void method() {
        System.out.println("子类方法");
    }

    public void methodZi() {
        System.out.println("子类特有方法");
    }
}

