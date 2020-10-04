/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.student;

/*
* 通常情况，一个类不能直接使用，需要根据类创建一个对象
* 1、导包
* 2、创建
* 3、使用
* */

public class NewStudent {
    public static void main(String[] args) {
        Student stu01 = new Student();

        stu01.name = "John";
        stu01.age = 30;

        System.out.println(stu01.name);
        System.out.println(stu01.age);

        stu01.eat();
        stu01.sleep();
        stu01.study();

    }
}
