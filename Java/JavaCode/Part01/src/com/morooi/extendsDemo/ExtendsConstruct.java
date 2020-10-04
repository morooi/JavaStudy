/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 18:01 CST
 */

package com.morooi.extendsDemo;

/*
* 继承关系中，父子类构造方法的访问特点：
*
* 1、子类构造方法中有一个默认隐含的"super()"调用，所以一定是先调用的父类构造，后执行的子类构造
* 2、子类构造可以通过super关键字来调用父类重装构造
* 3、super的父类构造调用，必须是子类构造方法的第一个语句。不能一个子类构造调用多次super构造。
*
* 总结：
*   子类必须调用父类构造方法，不写则赠送super(); 写了则用写的指定的super调用，super只能有一个，还必须是第一个
* */

public class ExtendsConstruct {
    public static void main(String[] args) {
        ZiConstruct ziConstruct = new ZiConstruct();
    }
}

class FuConstruct {
    public FuConstruct() {
        System.out.println("父类构造方法！");
    }

    public FuConstruct(int num) {
        System.out.println("父类构造方法！重载：" + num);
    }
}

class ZiConstruct extends FuConstruct {
    public ZiConstruct() {
//        super(); // 隐藏
        super(20);
        System.out.println("子类构造方法！");
    }
}