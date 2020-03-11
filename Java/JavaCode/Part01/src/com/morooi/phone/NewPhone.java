/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.phone;

public class NewPhone {
    public static void main(String[] args) {
        Phone phoneOne = new Phone();
        phoneOne.brand = "小米";
        phoneOne.color = "black";
        phoneOne.price = 1999;

        System.out.println(phoneOne.brand);
        System.out.println(phoneOne.color);
        System.out.println(phoneOne.price);

        phoneOne.call("Steve Jobs");
        phoneOne.sendMessage();
    }
}
