/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.arraylist;

/*
* ArrayList中常用的方法有：
*
* public boolean add(E e): 像集合中添加元素，参数的类型和泛型一致
* public E get(int index): 从集合中获取元素，参数是索引编号，返回值就是对应元素的位置
* public E remove(int index): 从集合中删除元素，参数是索引编号，返回值就是对应元素的位置
* public int size(): 获取集合的尺寸长度，返回值是集合中包含的元素个数
*
* */

import java.util.ArrayList;

public class ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        // 添加元素
        boolean success = list.add("Apple");
        System.out.println(success);

        list.add("Orange");
        list.add("Banana");
        list.add("Watermelon");
        System.out.println(list);

        System.out.printf("第2号位置：%s\n", list.get(2));

        String removeName = list.remove(1);
        System.out.printf("删除%s后的list：%s\n", removeName, list);

        System.out.println("list的长度：" + list.size());
    }
}
