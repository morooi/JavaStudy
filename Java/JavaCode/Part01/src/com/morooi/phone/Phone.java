/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.phone;


/*
* 定义一个类，模拟"手机"
*
* 属性：品牌、价格、颜色
* 行为：打电话、发短信
* */

public class Phone {
    // 成员变量
    String brand;
    String color;
    double price;

    // 成员方法
    public void call(String who) {
        System.out.println("给" + who + "打电话！");
    }

    public void sendMessage() {
        System.out.println("群发短信！");
    }
}
