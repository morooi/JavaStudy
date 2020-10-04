/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.constructionMethod;

public class NewStudent {
    public static void main(String[] args) {
        Student stu01 = new Student();
        stu01.setName("Steve Jobs");
        stu01.setAge(60);
        System.out.printf("我叫 %s, 我今年 %d 岁\n", stu01.getName(), stu01.getAge());

        System.out.println("=============");

        Student stu02 = new Student("Jay Chou", 30);
        System.out.printf("我叫 %s, 我今年 %d 岁\n", stu02.getName(), stu02.getAge());
    }
}
