/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 16:30 CST
 */

package com.morooi.polymorphism.field;

/*
 * 访问成员变量的两种方法：
 *
 * 1、直接通过对象名称访问成员变量：看等号左边是谁，优先用谁，没有则向上找
 * 2、间接通过成员方法访问成员变量：看该方法属于谁，优先用谁，没有则向上找
 * */

public class MultiField {
    public static void main(String[] args) {
        Fu obj = new Zi();
        System.out.println(obj.num); // Fu的成员变量
//        System.out.println(obj.age); // 错误写法！

        // 子类没有覆盖重写，就是父：10
        // 子类如果覆盖重写，就是子：20
        obj.showNum();
    }
}
