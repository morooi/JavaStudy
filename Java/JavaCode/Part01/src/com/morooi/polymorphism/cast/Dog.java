/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 17:27 CST
 */

package com.morooi.polymorphism.cast;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    public void watchHouse() {
        System.out.println("狗看家");
    }
}
