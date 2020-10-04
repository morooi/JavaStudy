/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 18:51 CST
 */

package com.morooi.interfaceDemo.demoLaptop;

public class Mouse implements USB {

    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    @Override
    public void function() {
        System.out.println("鼠标点击");
    }
}
