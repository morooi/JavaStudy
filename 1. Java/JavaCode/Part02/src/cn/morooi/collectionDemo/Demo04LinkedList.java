/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-10 20:01 CST
 */

package cn.morooi.collectionDemo;

/* java.util.LinkedList 集合 implement List 接口
 * 特点:
 *   1. 底层是一个链表结构: 查询慢, 增删快
 *   2. 里面包含了大量操作首尾元素的方法
 * 注意:
 *   使用 LinkedList 集合特有的方法, 不能使用多态
 *
 * 常用方法:
 *   public void addFirst(E e): 将指定元素插入此列表的开头
 *   public void addLast(E e): 将指定元素添加到此列表的结尾
 *   public void push(E e): 将元素推入此列表所表示的堆栈
 *
 *   public E getFirst(): 返回此列表的第一个元素
 *   public E getLast(): 返回此列表的最后一个元素
 *
 *   public E removeFirst(): 移除并返回此列表的第一个元素
 *   public E removeLast(): 移除并返回此列表的最后一个元素
 *   public E pop(): 从此列表所表示的堆栈处弹出一个元素
 *
 *   public boolean isEmpty(): 如果列表不包含元素, 则返回 true
 *
 * */

import java.util.LinkedList;

public class Demo04LinkedList {
    public static void main(String[] args) {
//        demo01();
//        demo02();
        demo03();
    }

    /*  public E removeFirst(): 移除并返回此列表的第一个元素
     *  public E removeLast(): 移除并返回此列表的最后一个元素
     *  public E pop(): 从此列表所表示的堆栈处弹出一个元素 (相当于removeFirst())
     * */
    private static void demo03() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        System.out.println(linkedList);

        System.out.println("linkedList.removeFirst() = " + linkedList.removeFirst());
        System.out.println("linkedList.pop() = " + linkedList.pop());
        System.out.println("linkedList.removeLast() = " + linkedList.removeLast());
        System.out.println("移除后: " + linkedList);
    }


    /* public E getFirst(): 返回此列表的第一个元素
     * public E getLast(): 返回此列表的最后一个元素
     * */
    private static void demo02() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(linkedList);

        if (!linkedList.isEmpty()) {
            System.out.println("linkedList.getFirst() = " + linkedList.getFirst());
            System.out.println("linkedList.getLast() = " + linkedList.getLast());
        }
    }

    /* public void addFirst(E e): 将指定元素插入此列表的开头
     * public void addLast(E e): 将指定元素添加到此列表的结尾
     * public void push(E e): 将元素推入此列表所表示的堆栈(添加到开头)
     * */
    private static void demo01() {
        LinkedList<String> linkedList = new LinkedList<>();
        // 使用 add 方法添加元素
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        System.out.println(linkedList); // [a, b, c, d]

        // public void addFirst(E e) 等效于 public void push(E e)
        linkedList.addFirst("ABC");
        System.out.println(linkedList); // [ABC, a, b, c, d]
        linkedList.push("ABC");
        System.out.println(linkedList); // [ABC, ABC, a, b, c, d]

        // public void addLast(E e) 等效于 public void add(E e)
        linkedList.addLast("EFG");
        System.out.println(linkedList); // [ABC, ABC, a, b, c, d, EFG]
        linkedList.add("EFG");
        System.out.println(linkedList); // [ABC, ABC, a, b, c, d, EFG, EFG]
    }
}
