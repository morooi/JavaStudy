/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-12 21:18 CST
 */

package cn.morooi.lambdaDemo;

/*
 * Java 内置的 4 大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accpet(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T, R>  R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 * */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Demo03FunctionalAPI {
    @Test
    public void test01() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("原来的写法" + aDouble);
            }
        });
        System.out.println("==================");
        happyTime(200, money -> System.out.println("lambda 写法" + money));
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("123", "124", "125", "434", "148");
        List<String> strings = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("2");
            }
        });
        System.out.println(strings);
        System.out.println("==================");
        List<String> strings1 = filterString(list, s -> s.contains("2"));
        System.out.println(strings1);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre) {
        List<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }
}
