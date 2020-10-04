/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:09 CST
 */

package com.morooi.interfaceDemo.staticDemo;

/*
 * 从Java 8开始，接口当中允许定义静态方法
 * 格式：
 * public static 返回值类型 方法名称(参数列表) {
 *     // 方法体
 * }
 *
 * 注意事项: 不能通过接口实现类的对象来调用接口当中的静态方法
 * 正确用法：通过接口名称，直接调用其中的静态方法
 * */

public class MyInterface {
    public static void main(String[] args) {
        MyInterfaceStaticImpl impl = new MyInterfaceStaticImpl();

        // 错误写法
//        impl.method();

        // 直接通过接口名称调用静态方法
        MyInterfaceStatic.method();
    }

}
