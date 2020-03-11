/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 21:20 CST
 */

package cn.morooi.collectionDemo;

/*
 * java.utils.Collections 是集合工具类, 用来对集合进行操作
 *   public static <T> void sort(List<T> list): 将集合中元素按照默认规则排序
 *   public static <T> void sort(List<T>, Comparator<? super T>): 将集合中元素按指定规则排序
 *
 * 注意:
 *   sort(List<T> list) 使用前提:
 *       被排序的集合里存储的元素, 必须实现 Comparable, 重写接口中的方法 compareTo 定义排序的规则
 *
 * Comparable 接口的排序规则:
 *   自己(this) - 参数 --> 升序
 *   参数 - 自己(this) --> 降序
 *
 * Comparator 接口的排序规则:
 *   o1 - o2 -> 升序
 *   o2 - o1 -> 降序
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo07Sort {
    public static void main(String[] args) {
        comparable();
//        comparator();
    }

    private static void comparator() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("b张三", 18));
        list.add(new Person("李四", 10));
        list.add(new Person("王五", 15));
        list.add(new Person("a王五", 18));
        System.out.println("排序前: " + list);

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                // 按照年龄升序排序
                int result = o1.getAge() - o2.getAge();
                // 如果两个人年龄相同, 再使用姓名的第一个字比较
                if (result == 0) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println("排序后: " + list);
    }

    private static void comparable() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三", 30));
        list.add(new Person("李四", 19));
        list.add(new Person("王五", 25));
        System.out.println("排序前: " + list);

        Collections.sort(list);
        System.out.println("排序后: " + list);
    }
}
