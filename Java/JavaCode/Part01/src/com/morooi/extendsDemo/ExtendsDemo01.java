/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 17:46 CST
 */

package com.morooi.extendsDemo;

public class ExtendsDemo01 {
    public static void main(String[] args) {
        Phone one = new Phone();
        NewPhone two = new NewPhone();

        System.out.println("手机功能：");
        one.call();
        one.sendMessage();
        one.show();

        System.out.println("=========");
        System.out.println("新手机功能");
        two.call();
        two.sendMessage();
        two.show();
    }
}

class Phone {
    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");
    }

    public void show() {
        System.out.println("显示号码");
    }
}

class NewPhone extends Phone {
    @Override
    public void show() {
        super.show(); // 直接使用父类的方法

        // 添加新的方法
        System.out.println("显示名称");
        System.out.println("显示头像");
    }
}
