/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 17:53 CST
 */

package cn.morooi.reflectionDemo;

/*
 * 反射:
 *  在运行时判断任意一个对象所属的类
 *  在运行时构造任意一个类的对象
 *  在运行时判断任意一个类所具有的成员变量和方法
 *  在运行时获取泛型信息
 *  在运行时调用任意一个对象的成员变量和方法
 *  在运行时处理注触
 *  生成动态代理
 *
 * 疑问: 通过直接 new 方式或反射的方式都可以调用公共的结构, 开发中到底用哪个?
 *      建议: 直接 new 方式
 *      什么是会用: 反射的方式, 反射的特征: 动态性
 *
 * 疑问: 反射机制与面向对象机制的封装性是不是矛盾的? 如何看待两个技术
 *      不矛盾.
 *
 * 关于 java.lang.Class 类的理解
 *  1. 类的加载过程:
 *      程序经过 javac 命令后, 会生成一个或多个字节码文件(.class 结尾), 接着我们使
 *      用 java 命令对某个字节码文件进行解释运行. 相当于将某个字节码文件加载到内存中.
 *      加载到内存中的类, 我们称为运行时类, 此运行时类, 就作为 Class 的一个实例
 *  2. 换句话说, Class 的实例就对应着一个运行时类
 *  3. 加载到内存中的运行时类, 会缓存一定的时间, 在此时间之内, 我们可以通过不同的方式来获取此运行时类
 * */

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo01Reflection {
    // 反射之前, 对于 Person 类的操作
    @Test
    public void test1() {
        // 1. 创建 Person 类的对象
        Person p1 = new Person("Tim", 23);
        // 2. 通过对象, 调用其内部的属性, 方法
        p1.age = 22;
        System.out.println(p1.getAge());

        p1.show();

        // 在 Person 类外部, 不可以通过 Person 类的对象调用其内部私有结构
        // 比如: name, showNation(), 以及私有的构造器
    }

    // 反射之后, 对于 Person 的操作
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        // 1. 通过反射, 创建 Person 类的对象
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person tim = constructor.newInstance("Tim", 12);
        System.out.println(tim);

        // 2. 通过反射,  调用对象指定的属性, 方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(tim, 10);
        System.out.println(tim);
        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(tim);

        System.out.println("========================");
        // 通过反射, 可以调用 Person 类的私有结构的. 比如: 私有的构造器, 方法, 属性
        // 调用私有的构造器
        Constructor<Person> constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person tom = constructor1.newInstance("Tom");
        System.out.println(tom);
        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom, "AAA");
        System.out.println(tom);
        // 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object nation = showNation.invoke(tom, "China"); // 相当于 tom.showNation("China")
        System.out.println(nation);
    }

    // 获取 Class 的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一: 调用运行时类的属性: .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // 方式二: 通过运行时的对象
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);

        // 方式三: 调用 Class 的静态方法: forName(String classPath)
        Class<?> clazz3 = Class.forName("cn.morooi.reflectionDemo.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz2 == clazz3); // true

        // 方式四: 内的加载器: ClassLoader
        ClassLoader classLoader = Demo01Reflection.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("cn.morooi.reflectionDemo.Person");
        System.out.println(clazz4);
    }

}
