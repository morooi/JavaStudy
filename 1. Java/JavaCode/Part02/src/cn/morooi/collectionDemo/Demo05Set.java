/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 19:32 CST
 */

package cn.morooi.collectionDemo;

/*
 * java.util.Set 接口 extends Collection 接口
 * - HashSet: 作为 Set 接口的主要实现类, 线程不安全, 可以存储 null 值
 * - LinkedHashSet: 作为 HashSet 的子类, 遍历其内部数据时可以按照添加的顺序遍历
 * - TreeSet: 可以按照添加对象的指定属性进行排序
 *
 * Set 特点:
 *  1. 不允许储存重复元素
 *  2. 没有索引，不能使用普通的for循环遍历
 *  3. 无序的集合 (存储和取出元素顺序有可能不一致)
 *
 * java.util.HashSet 集合 implements Set 接口
 * HashSet 特点:
 *  1. 不允许储存重复元素
 *  2. 没有索引，不能使用普通的for循环遍历
 *  3. 无序的集合 (存储和取出元素顺序有可能不一致)
 *  4. 底层是个哈希表结构 (查询速度非常快)
 *
 * java.util.LinkedHashSet 集合 extends HashSet 集合
 * LinkedHashSet 相比于 HashSet 特点:
 *  有序的集合:
 *      底层是一个哈希表(数组 + 链表/红黑树) + 链表 (多了一个链表记录元素的存储顺序, 保证元素有序)
 *
 * 补充:
 *  无序性: 不等于随机性, 存储的数据在底层数组中并非按照数组索引的顺序添加, 而是根据数据的哈希值决定的
 * */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Demo05Set {
    public static void main(String[] args) {
        demoHashSet();
        System.out.println("==========");
        demoLinkedHashSet();
    }

    private static void demoLinkedHashSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("b");
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("ccc");
        System.out.println(hashSet); // [a, b, ccc] 无序, 不允许重复

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("b");
        linkedHashSet.add("a");
        linkedHashSet.add("a");
        linkedHashSet.add("ccc");
        System.out.println(linkedHashSet); // [b, a, ccc] 有序, 不允许重复
    }

    private static void demoHashSet() {
        System.out.println("abc".hashCode()); // 计算"abc"的哈希值, 96354
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");

        // 使用迭代器或增强 for 循环遍历
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s : hashSet) {
            System.out.println(s);
        }
    }

}
