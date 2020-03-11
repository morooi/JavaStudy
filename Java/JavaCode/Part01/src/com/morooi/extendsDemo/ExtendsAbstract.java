/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 16:22 CST
 */

package com.morooi.extendsDemo;

/*
 * 抽象方法：就是加上abstract关键字，然后去掉大括号，直接分号结束
 * 抽象类：抽象方法所在的类，必须是抽象类才行。在class之前写上abstract即可
 *
 * 如何使用抽象类和抽象方法：
 * 1、不能直接创建new抽象类对象
 * 2、必须用一个子类继承抽象父类
 * 3、子类必须覆盖重写抽象父类当中所有的抽象方法
 *      覆盖重写（实现）：子类去掉抽象方法的abstract关键字，然后补上方法体大括号
 * 4、创建子类对象进行使用
 * */


public class ExtendsAbstract {
    public static void main(String[] args) {
//        Animals animals = new Animals(); // 错误写法，不能直接创建一个抽象类对象
        Cat cat = new Cat();
        cat.eat();
        cat.method();
    }
}

abstract class Animals {
    public Animals() {
        System.out.println("抽象父类构造方法！");
    }

    // 这是一个抽象方法，代表吃东西，但是具体吃什么不确定
    public abstract void eat();

    // 这是普通的成员方法
    public void method() {
        System.out.println("抽象父类的普通成员方法");
    }
}

class Cat extends Animals {
    public Cat() {
        System.out.println("子类构造方法！");
    }

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}