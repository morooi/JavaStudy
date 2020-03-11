/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-08 16:47 CST
 */

package com.morooi.polymorphism.method;

/*
 * 在多态的代码中，成员方法的访问规则是：
 *   看new的是谁，就优先用谁，没有则向上找
 *
 * 口诀：编译看左边，运行看右边
 *
 * 对比一下：
 * 成员变量：编译看左边，运行还看左边
 * 成员方法：编译看左边，运行看右边
 * */

public class MultiMethod {
    public static void main(String[] args) {
        Fu obj = new Zi(); // 多态

        obj.method(); // 父子都有，优先用子
        obj.methodFu(); // 子类没有，父类有，向上找

        // 编译看左，左边是Fu，Fu当中没有methodZi，所以编译报错。
//        obj.methodZi(); // 错误写法

    }
}
