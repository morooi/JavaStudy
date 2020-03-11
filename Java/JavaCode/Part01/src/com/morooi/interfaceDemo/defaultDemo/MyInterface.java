/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 15:01 CST
 */

package com.morooi.interfaceDemo.defaultDemo;

/*
 * 从java 8开始，接口里允许定义默认方法
 * 格式：
 * public default 返回值类型 方法名称(参数列表) {
 *     // 方法体
 * }
 *
 * 备注：接口当中的默认方法，可以解决接口升级的问题
 *
 * 1、接口的默认方法，可以通过接口实现类对象，直接调用
 * 2、接口的默认方法，也可以被接口实现类进行覆盖重写
 * */

public class MyInterface {
    public static void main(String[] args) {
        MyInterfaceDefaultImplA a = new MyInterfaceDefaultImplA();
        a.method01();
        a.method02();

        System.out.println("============");
        MyInterfaceDefaultImplB b = new MyInterfaceDefaultImplB();
        b.method01();
        b.method02();
    }
}
