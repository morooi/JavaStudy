/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 23:34 CST
 */

package cn.morooi.genericDemo;

public class GenericInterfaceDemo {
    public static void main(String[] args) {
        GenericInterfaceImpl1 gi1 = new GenericInterfaceImpl1();
        gi1.method("必须是字符串");

        GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2<>();
        gi2.method(123); // 指定了 Integer

        GenericInterfaceImpl2<Double> gi3 = new GenericInterfaceImpl2<>();
        gi3.method(8.9); // 指定了 Double
    }
}

