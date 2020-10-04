/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 14:46 CST
 */

package com.morooi.staticDemo;

/*
 * 一旦使用static修饰成员方法，那么这就成了静态方法。静态方法不属于对象，而是属于类的
 *
 * 如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用它
 * 如果有了static关键字，那么不需要创建对象，直接就能通过类名称使用它
 *
 * 无论是成员变量还是成员方法，如果有了static，都推荐使用类名称进行调用。
 * 静态变量： 类名称.静态变量
 * 静态方法： 类名称.静态方法()
 *
 * 注意：
 * 1、静态不能直接访问非静态。
 *      原因：因为在内存中是【先】有静态内容，【后】有非静态内容。
 * 2、静态方法中不能使用this
 *      原因：this代表当前对象
 * */

public class StaticMethod {
    public static void main(String[] args) {
        Test obj = new Test(); // 首先创建对象
        obj.method(); // 然后才能使用没有static关键字的内容

        // 对于静态方法来说，可以通过对象名进行调用，也可以直接通过类名称来调用
        obj.methodStatic(); // 正确，不推荐
        Test.methodStatic(); // 正确，推荐

        // 对于本类当中的静态方法，可以省略类名称
        myMethod();
        StaticMethod.myMethod(); // 完全等效
    }

    public static void myMethod() {
        System.out.println("我的方法");
    }
}

class Test {
    int num; // 成员变量
    static int numStatic; // 静态变量

    // 成员方法
    public void method() {
        System.out.println("这是一个成员方法");
        System.out.println(num); // 成员方法可以访问成员变量
        System.out.println(numStatic); // 成员方法可以访问静态变量
    }

    // 静态方法
    public static void methodStatic() {
        System.out.println("这是一个静态方法");
//        System.out.println(num); // 静态方法不能访问成员变量【重点】
        System.out.println(numStatic); // 静态方法可以访问静态变量
    }

}