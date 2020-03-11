/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 14:21 CST
 */

package com.morooi.staticDemo;

/*
 * 如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类。多个对象共享同一份数据。
 * */

public class StaticField {
    public static void main(String[] args) {
        Student stu01 = new Student("Steve Jobs", 20);
        Student stu02 = new Student("morooi", 25);

        Student.setRoom("101");

        System.out.printf("姓名：%s 年龄：%d 学号：%d 教室：%s\n",
                stu01.getName(), stu01.getAge(), stu01.getId(), Student.getRoom());
        System.out.printf("姓名：%s 年龄：%d 学号：%d 教室：%s\n",
                stu02.getName(), stu02.getAge(), stu02.getId(), Student.getRoom());
    }
}

class Student {
    private String name;
    private int age;
    private int id;
    private static String room;
    private static int idCounter = 0;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public Student() {
    }

    public static String getRoom() {
        return room;
    }

    public static void setRoom(String room) {
        Student.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}