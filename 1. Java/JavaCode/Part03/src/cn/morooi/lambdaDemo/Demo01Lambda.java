/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 21:54 CST
 */

package cn.morooi.lambdaDemo;

/*
 * Lambda 表达式的使用举例
 * */

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Demo01Lambda {
    @Test
    public void test01() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("什么什么什么鬼");
            }
        };
        runnable1.run();

        System.out.println("============");

        Runnable runnable2 = () -> System.out.println("Lambda 表达式");
        runnable2.run();
    }

    @Test
    public void test02() {
        Comparator<Integer> integerComparator1 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = integerComparator1.compare(11, 32);
        System.out.println(compare);

        System.out.println("============");
        // Lambda 表达式
        Comparator<Integer> integerComparator2 = (o1, o2) -> Integer.compare(o1, o2);
        compare = integerComparator2.compare(43, 32);
        System.out.println(compare);

        System.out.println("============");
        // 符号引用
        Comparator<Integer> integerComparator3 = Integer::compare;
        compare = integerComparator3.compare(231, 231);
        System.out.println(compare);
    }
}
