/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 22:32 CST
 */

package cn.morooi.genericDemo;

/*
 * 定义一个含有泛型的类, 模拟 ArrayList 集合
 *
 * 泛型是一个位置的数据类型, 当我们不确定什么数据类型的时候, 可以使用泛型
 * 泛型可以接收任意的数据类型, 可以使用 Integer, String, Student...
 * 创建对象的时候确定泛型的数据类型
 * */

public class GenericClass<E> {
    private E var;

    public E getVar() {
        return var;
    }

    public void setVar(E var) {
        this.var = var;
    }


}
