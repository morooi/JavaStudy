/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 13:28 CST
 */

package com.morooi.string;

/*
* 分割字符串的方法：
*
* public String[] split(String regex): 按照参数的规则，将字符串切分成若干部分。
*
* 注意：
* split方法的参数是一个"正则表达式"， "." --> "\\."
* */

public class String06Split {
    public static void main(String[] args) {
        String[] array1 = "aaa,bbb,ccc".split(",");
        for (String s : array1) {
            System.out.println(s);
        }
        System.out.println("================");

        String[] array2 = "aaa bbb ccc".split(" ");
        for (String s : array2) {
            System.out.println(s);
        }
        System.out.println("================");

        String[] array3 = "aaa.bbb.ccc".split("\\.");
        for (String s : array3) {
            System.out.println(s);
        }
    }
}
