/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 17:36 CST
 */

package cn.morooi.collectionDemo;

/*
 * java.util.Iterator 接口: 迭代器(对集合进行遍历)
 * 有两个常用方法:
 *   boolean hasNext(): 如果仍有元素可以迭代, 则返回true, 没有就返回false
 *   E next(): 返回迭代的下一个元素
 *
 * Iterator 迭代器是一个接口, 无法直接使用
 * Collection 接口中有个方法, iterator(), 这个方法返回的就是迭代器的实现类对象
 *  Iterator<E> iterator(): 返回在此 collection 的元素上进行迭代的迭代器
 *
 * 迭代器的使用步骤(重点):
 *  1. 使用 Collection 中的方法 iterator() 获取迭代器的实现类对象, 使用 Iterator 接口接收(多态)
 *  2. 使用 Iterator 接口中的方法 hasNext 判断还有没有下一个元素
 *  3. 使用 Iterator 接口中的方法 next 取出集合中的下一个元素
 *
 * 增强 for 循环 (foreach), 底层使用的也是迭代器, 使用 for 循环的格式, 简化了迭代器的书写
 * 是 JDK 1.5 之后出现的新特性
 * 所有的单列集合都可以使用增强 for 循环
 *
 * 增强 for 循环: 用来遍历集合和数组 (注意: 目标只能是 Collection 或 数组, 且仅仅作为遍历操作出现)
 * 格式:
 *  for (集合/数组的数据类型 变量名: 集合/数组名) {
 *      ...
 *  }
 *
 * 补充: Iterator 中的 remove()
 *
 * */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo02Iterator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("迪丽热巴");
        coll.add("古力娜扎");
        coll.add("马尔扎哈");

        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        // 或
        for (Iterator<String> it = coll.iterator(); it.hasNext(); ) {
            System.out.println("it.next() = " + it.next());
        }

        // 增强 for 循环, 内部依然调用了迭代器
        for (String s : coll) {
            System.out.println("s = " + s);
        }
        int[] arrayInt = {1, 2, 3, 4, 5};
        for (int i : arrayInt) {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void removeTest() {
        Collection<String> coll = new ArrayList<>();
        coll.add("迪丽热巴");
        coll.add("古力娜扎");
        coll.add("马尔扎哈");

        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("古力娜扎".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(coll);
    }
}
