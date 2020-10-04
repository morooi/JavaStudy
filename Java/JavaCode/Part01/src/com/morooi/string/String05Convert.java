/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-01 22:55 CST
 */

package com.morooi.string;

/*
* String 中与转换相关的常用方法
*
* public char[] toCharArray(): 将当前字符串拆分成为字符数组作为返回值。
* public byte[] getBytes(): 获取当前字符串底层的字节数组
* public String replace(CharSequence oldString, CharSequence newString):
*   将所有出现的老字符串替换成为新的字符串，返回替换后的结果新字符串
* */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class String05Convert {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 转换成字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);

        // 转换成字节数组
        byte[] bytes = "你好abc".getBytes(); // 默认的字符集
        byte[] bytes2 = "你好abc".getBytes("GBK"); //

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));
        System.out.println(bytes.length);

        // 字符串的内容替换
        String str1 = "How do yo do?";
        String str2 = str1.replace("o", "*");
        System.out.println(str1); // How do yo do?
        System.out.println(str2); // H*w d* y* d*?
    }
}
