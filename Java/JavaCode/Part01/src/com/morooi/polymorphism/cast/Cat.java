/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 17:48 CST
 */

package com.morooi.polymorphism.cast;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
        catchMouse();
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}
