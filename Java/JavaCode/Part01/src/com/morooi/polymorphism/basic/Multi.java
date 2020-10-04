/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 16:17 CST
 */

package com.morooi.polymorphism.basic;

/*
 * 代码当中体现多态性，其实就是一句话：父类引用指向子类对象
 *
 * 格式：
 *  父类名称 对象名 = new 子类名称();
 * 或者：
 *  接口名称 对象名 = new 实现类名称();
 * */

public class Multi {
    public static void main(String[] args) {
        Fu obj = new Zi();

        obj.method(); // 子类方法
        obj.methodFu(); // 父类特有方法
    }
}
