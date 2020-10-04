/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 16:00 CST
 */

package com.morooi.extendsDemo;

/*
 * 局部变量：          直接写成员变量名
 * 本类的成员变量：     this.成员变量名
 * 父类的成员变量：     super.成员变量名
 * */

public class ExtendsField {
    public static void main(String[] args) {
        Zi obj = new Zi();

        obj.method();
    }
}

class Fu {
    int num = 10;
}

class Zi extends Fu {
    int num = 20;

    public void method() {
        int num = 30;

        System.out.println("局部变量：" + num);
        System.out.println("本类成员变量：" + this.num);
        System.out.println("父类成员变量：" + super.num);
    }
}