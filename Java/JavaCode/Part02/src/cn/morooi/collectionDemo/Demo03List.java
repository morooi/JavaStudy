/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 19:19 CST
 */

package cn.morooi.collectionDemo;

/*
 * java.util.List 接口, extends Collection 接口:
 *      - Vector 集合: 作为 List 接口的古老实现类 (线程安全, 效率低), 底层使用 Object[] 存储
 *      - ArrayList 集合: 作为 List 接口的主要实现类 (线程不安全, 效率高), 底层使用 Object[] 存储
 *      - LinkedList 集合: 对于频繁的插入, 删除操作, 使用此类效率比 ArrayList 高, 底层使用双向链表存储
 *      特点： 有序的集合（存储和取出元素顺序相同）
 *            允许存储重复的元素
 *            有索引，可以使用普通的for循环遍历
 *
 * List 接口中带索引的方法有(特有):
 *      public void add(int index, E element): 将指定的元素, 添加到该集合中的指定位置上
 *      public E get(int inedx): 返回集合中指定位置的元素
 *      public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素
 *      public E set(int inedx, E element): 用指定元素替换集合中指定位置的元素, 返回更新前的元素
 *      public int indexOf(Object obj): 返回 obj 在集合中首次出现的位置, 没有为 -1
 *      public int lsatIndexOf(Object obj): 返回 obj 在集合中末次出现的位置, 没有为 -1
 *
 * 注意: 操作索引时, 一定要防止索引越界异常
 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo03List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 使用 add 方法添加
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        System.out.println(list); // [a, b, c, d, a]

        // public void add(int index, E element)
        list.add(2, "abc");
        System.out.println(list); // [a, b, abc, c, d, a]

        // public E remove(int index)
        String remove = list.remove(3);
        System.out.println("remove = " + remove); // c
        System.out.println(list); // [a, b, abc, d, a]

        // public E set(int inedx, E element)
        String set = list.set(4, "A"); // a
        System.out.println("set = " + set);
        System.out.println(list); // [a, b, abc, d, A]
        System.out.println("==========");

        // List 集合遍历有3种方式
        // for 循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=========");

        // 迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("=========");

        // 增强 for 循环
        for (String s : list) {
            System.out.println(s);
        }
    }
}
