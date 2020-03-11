/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 20:54 CST
 */

package cn.morooi.lambdaDemo;

/*
 * lambda 表达式的使用
 *   1. 举例: (o1, o2) -> Integer.compare(o1, o2)
 *   2. 格式:
 *       ->: lambda 操作符 或 箭头操作符
 *       -> 的左边: lambda 的新参列表(其实就是接口中的抽象方法的形参列表)
 *       -> 的右边: lambda 体(其实就是重写的抽象方法的方法体)
 *   3. lambda 表示式的使用: (6 种情况)
 *       总结:
 *          -> 的左边: lambda 形参列表的参数类型可以省略(类型推断), 如果 lambda 形参列表只有一个参数, 可省去括号
 *          -> 的右边: lambda 体应该使用一对 {} 包括, 如果 lambda 体只有一条执行语句(可能是 return 语句), 省略掉 {} 和 return
 *   4. lambda 表达式的本质: 作为函数式接口的实例
 *   5. 如果一个接口中, 只声明了一个抽象方法, 则称此接口为函数式接口
 *
 * */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Demo02Lambda {
    // 语法格式一: 无参, 无返回值
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

        Runnable runnable2 = () -> {
            System.out.println("lambda 表达式");
        };
        runnable2.run();
    }

    // 语法格式二: lambda 需要一个参数, 但是没有返回值
    @Test
    public void test02() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("这是一个东西");

        System.out.println("============");

        Consumer<String> con2 = (String s) -> {
            System.out.println(s);
        };
        con2.accept("这又是一个东西");
    }

    // 语法格式三: 数据类型可以省略, 因为可由编译器推断得出, 称为"类型推断"
    @Test
    public void test03() {

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("这是一个东西");

        System.out.println("============");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("这又是一个东西");
    }

    // 语法格式四: lambda 若只需要一个参数时, 参数的小括号可以省略
    @Test
    public void test04() {

        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("这是一个东西");

        System.out.println("============");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("这又是一个东西");
    }

    // 语法格式五: lambda 需要两个或以上的参数, 多条执行语句, 并且可以有返回值
    @Test
    public void test05() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(22, 11));

        System.out.println("============");

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(6, 11));
    }

    // 语法格式六: 当 lambda 体只有一条语句时, return 与大括号若有, 都可以省略
    @Test
    public void test06() {
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(6, 11));
        System.out.println("============");

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(66, 11));
    }
}
