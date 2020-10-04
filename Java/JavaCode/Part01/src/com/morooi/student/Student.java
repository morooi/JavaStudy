/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.student;

/*
* 定义一个类，模拟"学生"事物，有两个组成部分：
*
* 属性（是什么）：
*   姓名
*   年龄
* 行为（能做什么）：
*   吃饭
*   睡觉
*   学习
*
* 对应到Java的类中：
*
* 成员属性（属性）：
*   String name; // 姓名
*   int age; // 年龄
* 成员方法（行为）：
*   public void eat(); // 吃饭
*   public void sleep(); // 睡觉
*   public void study(); // 学习
*
* 注意：
* 1、成员变量是直接定义在类当中的，在方法外边。
* 2、成员方法不要写static关键字
* */

public class Student {

    // 成员变量
    String name;
    int age;

    // 成员方法
    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public void study() {
        System.out.println("学习");
    }
}
