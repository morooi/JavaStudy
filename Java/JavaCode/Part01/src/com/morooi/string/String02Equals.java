/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.string;

/*
 * "==" 是进行对象的地址值比较，如果确实需要字符串的内容比较，可以使用两个方法：
 *
 * public boolean equals(Object obj): 参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true，否则返回false
 * 注意事项：
 * 1、任何对象都能用Object进行接收
 * 2、equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样
 * 3、如果比较双方一个常量一个变量，推荐把常量字符串写在前面
 *   推荐："abc".equals(str)    不推荐：str.equals("abc")
 *
 * public boolean equalsIgnoreCase(String str): 忽略大小写，进行内容比较。
 * */

public class String02Equals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2)); // true
        System.out.println(str2.equals(str3)); // true
        System.out.println(str3.equals("Hello")); // true 不推荐
        System.out.println("Hello".equals(str3)); // true 推荐

        String str4 = "hello";
        System.out.println(str4.equals(str1)); // false
        System.out.println(str4.equalsIgnoreCase(str1)); // true

    }

}
