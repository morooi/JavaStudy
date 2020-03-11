/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:00 CST
 */

package com.morooi.interfaceDemo.basicDemo;

/*
 * 接口就是多个类的公共规范
 * 接口是一种引用数据类型，最重要的内容就是其中的：抽象方法
 *
 * 定义一个接口：
 * public interface 接口名称 {
 *     // 接口内容
 * }
 *
 * 备注：
 * 如果使用Java 7，接口中可以包含的内容有：
 * 1、常量
 * 2、抽象方法
 *
 * 如果使用Java 8，可以额外包含有：
 * 3、默认方法
 * 4、静态方法
 *
 * 如果使用Java 9，还可以额外包含：
 * 5、私有方法
 *
 * 接口使用步骤：
 * 1、接口不能直接使用，必须有一个"实现类"来"实现"该接口。
 * 格式：
 * public class 实现类名称 implements 接口名称 {
 *    // ...
 * }
 *
 * 2、接口的实现类必须覆盖重写（实现）接口中所有的抽象方法
 *    实现：去掉abstract关键字，加上方法体大括号
 *
 * 3、创建实现类的对象，进行使用。
 *
 * 注意：如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己就必须是抽象类
 * */

public class MyInterface {
    public static void main(String[] args) {
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();
        impl.methodAbs3();
        impl.methodAbs4();
    }
}
