/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 13:02 CST
 */

package com.morooi.string;

/*
 * 字符串的截取方法：
 *
 * public String substring(int index): 截取从参数位置一直到字符串末尾，返回新字符串
 * public String substring(int begin, int end): 截取从begin开始，一直到end结束，中间的字符串
 * 备注：[begin, end)
 * */

public class String04Substring {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str2 = str1.substring(2);
        String str3 = str1.substring(2, 5);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
