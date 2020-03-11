/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 17:17 CST
 */

package cn.morooi.collectionDemo;

/*
 * java.util.Collection：所有单列集合的最顶层的接口，里面定义了所有单列集合共性的方法
 *   1、List 接口：
 *       - Vector 集合
 *       - ArrayList 集合
 *       - LinkedList 集合
 *       特点： 有序的集合（存储和取出元素顺序相同）
 *             允许存储重复的元素
 *             有索引，可以使用普通的for循环遍历
 *   2、Set 接口
 *       - TreeSet 集合
 *       - HashSet 集合
 *           - LinkedHashSet 集合
 *       特点： 不允许储存重复元素
 *             没有索引，不能使用普通的for循环遍历
 *             TreeSet 和 HashSet 为无序的集合（存储和取出元素顺序有可能不一致）
 *             LinkedHashSet 为有序的集合
 *
 * Collection 是所有单列集合的父类接口，有些通用的方法，可用于操作所有的单列集合：
 *      public boolean add(E e):        把给定的对象添加到当前集合中
 *      public boolean remove(E e):     把给定的对象在当前集合中删除
 *      public boolean contains(E e):   判断当前集合中是否包含给定的对象
 *      public boolean isEmpty():       判断当前集合是否为空
 *      public int size():              返回集合中元素的个数
 *      public void clear():            清空集合中所有的元素
 *      public Object[] toArray():      把集合中的元素储存到数组中
 *
 *      removeAll(Collection coll): 差集: 从当前集合中移除 coll 中所有的元素
 *      retainAll(Collection coll): 交集: 获取当前集合和 coll 集合的交集, 并返回给当前集合
 * */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo01Collection {
    public static void main(String[] args) {
        // 可以使用多态
        Collection<String> coll01 = new ArrayList<>();

         // public boolean add(E e): 把给定的对象添加到当前集合中
        coll01.add("迪丽热巴");
        coll01.add("古力娜扎");
        coll01.add("马尔扎哈");
        System.out.println("coll = " + coll01); // coll = [迪丽热巴, 古力娜扎, 马尔扎哈]
        System.out.println("==============");

        // public boolean remove(E e): 把给定的对象在当前集合中删除
        boolean result01 = coll01.remove("马尔扎哈"); // 成功返回 true
        boolean result02 = coll01.remove("嘻嘻嘻"); // 失败返回 false，因为不存在
        System.out.println("result01 = " + result01);
        System.out.println("result02 = " + result02);
        System.out.println("coll = " + coll01); // coll = [迪丽热巴, 古力娜扎]
        System.out.println("==============");

        // public boolean contains(E e): 判断当前集合中是否包含给定的对象, 调用重写的 equals 方法
        boolean result03 = coll01.contains("迪丽热巴"); // 存在返回 true
        boolean result04 = coll01.contains("哈哈哈"); // 不存在返回 false
        System.out.println("result01 = " + result03);
        System.out.println("result02 = " + result04);
        System.out.println("==============");

        // public boolean isEmpty(): 判断当前集合是否为空
        Collection<String> coll02 = new ArrayList<>();
        System.out.println("coll01.isEmpty() = " + coll01.isEmpty());
        System.out.println("coll02.isEmpty() = " + coll02.isEmpty());
        System.out.println("==============");

        // public int size(): 返回集合中元素的个数
        System.out.println("coll01.size() = " + coll01.size());
        System.out.println("coll02.size() = " + coll02.size());
        System.out.println("==============");

        // public void clear(): 清空集合中所有的元素(不删除集合)
        System.out.println("coll01 = " + coll01);
//        coll01.clear();
        System.out.println("coll01 = " + coll01);
        System.out.println("==============");

        // public Object[] toArray(): 把集合中的元素储存到数组中
        Object[] array = coll01.toArray();
        for (Object o : array) {
            System.out.println(o);
        }
        System.out.println("array = " + Arrays.toString(array));
    }

    @Test
    public void retainAllTest() {
        // retainAll(): 交集: 获取当前集合和 coll 集合的交集, 并返回给当前集合
        Collection<String> coll1 = new ArrayList<>();
        coll1.add("迪丽热巴");
        coll1.add("古力娜扎");
        coll1.add("马尔扎哈");
        System.out.println("coll1 = " + coll1);

        Collection<String> coll2 = new ArrayList<>();
        coll2.add("迪丽热巴");
        coll2.add("马尔扎哈");
        System.out.println("coll2 = " + coll2);

        coll1.retainAll(coll2);
        System.out.println(coll1);
    }
}
