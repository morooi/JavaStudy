/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 15:43 CST
 */

package cn.morooi.mapDemo;

/*
 * JDK 9的新特性:
 *   List 接口, Set 接口, Map 接口: 增加了一个静态方法 of, 可以给集合一次性添加多个元素
 *   static <E> List<E> of(E... elements)
 *   使用前提: 当集合中存储的元素的个数已经确定了, 不再改变时使用
 *
 * 注意:
 * 1. of 方法只适用于 List 接口, Set 接口, Map 接口, 不适用于接口的实现类
 * 2. of 方法的返回值是一个不能改变的集合, 集合不能再使用 add, put 方法添加元素, 会抛出异常
 * 3. Set 接口和 Map 接口在调用 of 方法的时候, 不能有重复元素, 否则会抛出异常
 *
 *
 * */

public class Demo05JDK9 {
    public static void main(String[] args) {
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        System.out.println(list);
//
//        Set<Integer> set = Set.of(1, 3, 4, 5, 2);
//        System.out.println(set);
//
//        Map<String, Integer> map = Map.of("1", 22, "3", 44);
//        System.out.println(map);
    }
}
