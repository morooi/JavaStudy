/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 19:01 CST
 */

package com.morooi.interfaceDemo.demoLaptop;

public class Laptop {
    public void powerOn() {
        System.out.println("笔记本电脑开机");
    }

    public void powerOff() {
        System.out.println("笔记本电脑关机");
    }

    public void useDevice(USB device) {
        device.open();
        device.function();
        device.close();
    }
}
