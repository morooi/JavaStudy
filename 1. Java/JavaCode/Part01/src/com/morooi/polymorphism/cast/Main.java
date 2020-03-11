/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 17:48 CST
 */

package com.morooi.polymorphism.cast;

/*
* 如何才能知道一个父类的引用对象，本来是什么子类
*
* 格式：
*   对象 instanceof 类名称
* 这将会得到一个boolean值结果
* */


public class Main {
    public static void main(String[] args) {
        GiveMeAPet(new Cat());
        System.out.println("=============");
        GiveMeAPet(new Dog());
    }

    public static void GiveMeAPet(Animal animal) {
        // 如果希望用子类特有方法，需要向下转型
        // 判断一下父类引用animal是什么
        if (animal instanceof Cat) {
            animal.eat();
            Cat cat = (Cat) animal;
            cat.catchMouse();
        } else if (animal instanceof Dog) {
            animal.eat();
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
    }
}
