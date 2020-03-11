/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-10 22:31 CST
 */

package cn.morooi.ioStreamDemo;


/*
 * Person 类需要满足如下要求, 方可序列化
 * 1. 需要实现接口: Serializable
 * 2. 当前类提供一个全局常量: serialVersionUID
 * 3. 除了当前 Person 类需要实现 Serializable 接口之外, 还必须保证其内部所有属性也必须是可序列化的
 *      (默认情况下, 基本数据类型可序列化)
 *
 * 补充: ObjectInputStream 和 ObjectOutputStream 不能序列化 static 和 transient 修饰的成员变量
 * */


import java.io.Serializable;

public class Person implements Serializable {
    public static final long serialVersionUID = 12718364783L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
