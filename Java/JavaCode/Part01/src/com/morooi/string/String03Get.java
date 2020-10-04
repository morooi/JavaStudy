/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:58 CST
 */

package com.morooi.string;

/*
 * String 当中与获取相关的常用方法有
 *
 * public int length(): 获取字符串当中含有的字符个数，拿到字符串长度。
 * public String concat(String str): 将当前字符串和参数字符串拼接成为返回值新的字符串
 * public char charAt(int index): 获取指定索引位置的单个字符（从0开始）
 * public int indexOf(String str): 查找参数字符串在本字符串中首次出现的索引位置，如果没有返回-1
 * */

public class String03Get {
    public static void main(String[] args) {
        // 获取字符串的长度
        int length = "什么东西abc".length();
        System.out.println("字符串的长度：" + length);

        // 拼接字符串
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println(str1); // Hello，原封不动
        System.out.println(str2); // World，原封不动
        System.out.println(str3); // HelloWorld，新的字符串

        // 获取指定索引位置的单个字符
        System.out.println("Hello".charAt(0));

        // 查找参数字符串在本来字符串中出现的第一次索引位置
        String original = "HelloWorldHelloWorldHelloWorld";
        int index = original.indexOf("llo");
        System.out.println("第一次索引值是：" + index); // 2
        System.out.println("HelloWorld".indexOf("abc")); // -1
    }
}
