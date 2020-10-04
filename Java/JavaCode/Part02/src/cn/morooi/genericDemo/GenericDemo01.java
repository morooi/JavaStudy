/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 23:56 CST
 */

package cn.morooi.genericDemo;

/*
 * 泛型的通配符:
 *       ?: 代表任意的数据类型
 * 使用方法:
 *       不能直接创建对象使用
 *       只能作为方法的参数使用
 * */

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo01 {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);
        list01.add(3);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("c");
        list02.add("b");

        printList(list01);
        printList(list02);
    }

    /*
     * 定义一个方法, 能遍历所有类型的 ArrayList 集合
     * 这时我们不知道 ArrayList 集合使用什么数据类型, 可使用泛型通配符 ? 来接收数据类型
     * */
    private static void printList(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next(); // 取出的元素是 Object, 可以接收任意的数据类型
            System.out.println(next);
        }
    }
}
