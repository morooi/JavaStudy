/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-10 00:03 CST
 */

package cn.morooi.genericDemo;

/*
 * 泛型的上限限定:   ? extends E   代表使用的泛型只能是 E 类型的子类/本身
 * 泛型的下限限定:   ? super E     代表使用的泛型只能是 E 类型的父类/本身
 * */

import java.util.ArrayList;
import java.util.Collection;

public class GenericDemo02 {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<>();
        Collection<Number> list2 = new ArrayList<>();
        Collection<String> list3 = new ArrayList<>();
        Collection<Object> list4 = new ArrayList<>();

        getElement1(list1); // 子类
        getElement1(list2); // 本身
//        getElement1(list3); // 不是子类, 报错
//        getElement1(list4); // 不是子类, 报错

//        getElement2(list1); // 不是父类, 报错
        getElement2(list2); // 本身
//        getElement2(list3); // 不是父类, 报错
        getElement2(list4); // 父类

    }

    // 泛型的上限: 此时的泛型 ? 必须是 Number 的子类或本身
    private static void getElement1(Collection<? extends Number> list) {
    }

    // 泛型的下限: 此时的泛型 ? 必须是 Number 的父类或本身
    private static void getElement2(Collection<? super Number> list) {
    }
}
