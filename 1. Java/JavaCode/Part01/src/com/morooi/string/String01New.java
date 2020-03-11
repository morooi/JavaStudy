/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-04 11:27 CST
 */

package com.morooi.string;

/*
 * java.lang.String类代表字符串。
 * API当中说: Java程序中的所有字符串字面值(如 "abc" )都作为此类的实例实现。
 * 其实就是说:程序当中所有的双引号字符串，都是String类的对象。 (就算没有new,也照样是)
 *
 * 字符串的特点:
 * 1. 字符串的内容永不可变。 [重点]
 * 2. 正是因为字符串不可改变，所以字符串是可以共享使用的。
 * 3. 字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。
 *
 * 创建字符串的常见3+1种方式。
 * 三种构造方法(构造器方法: 创建了两个新的对象, 一个在堆中的 new, 一个在字符串常量池中的 char[]):
 *   public String(): 创建一个空白字符串，不含有任何内容。
 *   public String(char[] array): 根据字符数组的内容，来创建对应的字符串。
 *   public String(byte[] array): 根据字节数组的内容，来创建对应的字符串。
 * 一种直接创建:
 *   String str = "Hello"
 * */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class String01New {
    public static void main(String[] args) {
        // 使用空参构造
        String str1 = new String("abc"); // 小括号留空说明什么内容都没有
        System.out.println("第1个字符串：" + str1);

        // 根据字符数组创建字符串
        char[] charArray = {'A', 'B', 'C'};
        String str2 = new String(charArray);
        System.out.println("第2个字符串：" + str2);

        // 根据字节数组创建字符串
        byte[] byteArray = {'a', 98, 'c'};
        String str3 = new String(byteArray);
        System.out.println("第3个字符串：" + str3);

        // 直接创建
        String str4 = "Hello";
        System.out.println("第4个字符串：" + str4);
    }


    /*
     * 1. 常量与常量的拼接结果在常量池, 常量池不会存在相同内容的常量
     * 2. 只要有一个是变量, 结果就在堆中
     * 3. 如果拼接的结果调用 intern() 方法, 返回值就在常量池中
     * 4. 被 final 修饰的是常量
     * */
    @Test
    public void test1() {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + s2;
        String s6 = "hello" + s2;
        String s7 = s1 + "world";

        System.out.println("s3 == s4: " + (s3 == s4)); // true
        System.out.println("s3 == s5: " + (s3 == s5)); // false
        System.out.println("s3 == s6: " + (s3 == s6)); // false
        System.out.println("s3 == s7: " + (s3 == s7)); // false
        System.out.println("s4 == s5: " + (s4 == s5)); // false

        String s8 = s5.intern(); // 返回值得到的 s8 使用的常量值中已经存在的 "helloworld"
        System.out.println(s3 == s8); // true

        final String fin = "hello";
        String s9 = fin + "world";
        System.out.println("s3 == s9 = " + (s3 == s9)); // true, fin 被 final 修饰, 也是常量

    }

    @Test
    public void asd() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i <= 71; i++) {
            strings.add("pre" + i);
        }
        System.out.println(strings);
    }
}
