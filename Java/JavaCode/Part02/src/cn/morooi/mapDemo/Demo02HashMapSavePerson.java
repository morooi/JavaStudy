/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 14:51 CST
 */

package cn.morooi.mapDemo;

/*
* HashMap 存储自定义类型键值
* Map 集合保证 key 是唯一的:
*   作为 key 的元素, 必须重写 hashCode 方法和 equals 方法, 以保证 key 唯一
* */

import java.util.HashMap;

public class Demo02HashMapSavePerson {
    public static void main(String[] args) {
        Person one = new Person(1, "Apple");
        Person two = new Person(2, "Pig");
        Person three = new Person(3, "Monkey");
        Person four = new Person(3, "Apple");

        HashMap<Integer, Person> hashMap = new HashMap<>();
        hashMap.put(1, one);
        hashMap.put(2, two);
        hashMap.put(3, three);
        hashMap.put(2, four);

        System.out.println(hashMap);

        HashMap<Person, Integer> hashMap1 = new HashMap<>();
        hashMap1.put(one, 111);
        hashMap1.put(two, 222);
        hashMap1.put(three, 333);
        hashMap1.put(four, 444);

        System.out.println(hashMap1);
    }
}
