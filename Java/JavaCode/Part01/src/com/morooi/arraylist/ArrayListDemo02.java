/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.arraylist;

import java.util.ArrayList;

public class ArrayListDemo02 {
    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(new Student("A", 12));
        stuList.add(new Student("B", 22));
        stuList.add(new Student("C", 21));
        stuList.add(new Student("D", 20));

        for (Student student : stuList) {
            System.out.printf("姓名：%s，年龄：%d\n", student.getName(), student.getAge());
        }
    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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
}
