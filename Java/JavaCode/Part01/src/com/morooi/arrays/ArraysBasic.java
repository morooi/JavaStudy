/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 15:11 CST
 */

package com.morooi.arrays;

/*
 * java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。
 *
 * public static String toString(数组): 将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
 * public static void sort(数组): 按照默认升序（从小到大）对数组的元素进行排序。
 *
 * 备注：
 * 1、如果是数值，sort默认按照升序从小到大
 * 2、如果是字符串，sort默认按照字母升序
 * 3、如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。
 *
 * */

import java.util.Arrays;

public class ArraysBasic {
    public static void main(String[] args) {
        int[] arrays01 = {2, 1, 3};
        System.out.println(Arrays.toString(arrays01)); // [2, 1, 3]

        Arrays.sort(arrays01); // 无返回值
        System.out.println(Arrays.toString(arrays01)); // [1, 2, 3]

        String[] arrays02 = {"bbb", "aaa", "ccc"};
        Arrays.sort(arrays02);
        System.out.println(Arrays.toString(arrays02)); // [aaa, bbb, ccc]
    }
}
