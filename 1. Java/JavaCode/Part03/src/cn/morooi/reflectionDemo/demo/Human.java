/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 22:37 CST
 */

package cn.morooi.reflectionDemo.demo;

@MyAnnotation(value = "Hi")
public class Human extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Human() {}

    @MyAnnotation("123")
    private Human(String name) {
        this.name = name;
    }

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是: " + nation);
        return nation;
    }

    public String display(String interest, int age) throws NullPointerException, ClassCastException {
        return interest + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
}
