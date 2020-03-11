/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 23:11 CST
 */

package cn.morooi.genericDemo;

public class GenericMethodDemo {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.method("abc");
        gm.method(123);
        gm.method(true);

        System.out.println("==========");
        GenericMethod.methodStatic("def");
        GenericMethod.methodStatic(456);
        GenericMethod.methodStatic(false);
    }
}
