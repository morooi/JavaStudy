/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 18:54 CST
 */

package com.morooi.interfaceDemo.demoLaptop;

public class Keyboard implements USB {

    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    @Override
    public void function() {
        System.out.println("键盘敲击");
    }


}
