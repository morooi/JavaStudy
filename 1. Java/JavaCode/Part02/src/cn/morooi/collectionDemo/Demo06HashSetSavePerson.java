/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-10 21:14 CST
 */

package cn.morooi.collectionDemo;

/* HashSet 存储自定义类型元素
 *
 * Set 集合报错元素唯一:
 *  存储的元素(String, Integer, ..., Student, Person, ...), 必须重写 hashCode() 和 equals() 方法
 *
 * 要求: 同名同年龄的人, 视为同一个人, 只能存储一次
 * */

import java.util.HashSet;

public class Demo06HashSetSavePerson {
    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        Person one = new Person("张三", 20);
        Person two = new Person("张三", 20);
        Person three = new Person("张三", 30);

        people.add(one);
        people.add(two);
        people.add(three);

        System.out.println(people);
    }
}
