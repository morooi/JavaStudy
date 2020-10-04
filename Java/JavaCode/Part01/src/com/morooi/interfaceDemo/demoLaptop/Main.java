/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 18:55 CST
 */

package com.morooi.interfaceDemo.demoLaptop;

public class Main {
    public static void main(String[] args) {
        // 创建一个笔记本电脑
        Laptop laptop = new Laptop();
        laptop.powerOn(); // 开机
        laptop.useDevice(new Mouse());
        laptop.useDevice(new Keyboard());
        laptop.powerOff();
    }
}
