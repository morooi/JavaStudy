/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 22:33 CST
 */

package cn.morooi.genericDemo;

public class GenericClassDemo {
    public static void main(String[] args) {
        GenericClass<Object> obj = new GenericClass<>();
        obj.setVar("不指定类型则为 Object 类型");
        System.out.println(obj.getVar());

        GenericClass<String> gc1 = new GenericClass<>();
        gc1.setVar("这是一个字符串");
        System.out.println(gc1.getVar());

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setVar(1);
        System.out.println(gc2.getVar());
    }
}
