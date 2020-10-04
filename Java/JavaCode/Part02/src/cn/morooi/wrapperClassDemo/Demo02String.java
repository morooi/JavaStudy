/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-01 22:41 CST
 */

package cn.morooi.wrapperClassDemo;

/*
 * 基本类型与字符串类型之间的互相转换
 * 基本类型 -> 字符串（String）
 *      1、基本类型的值 + "" （空字符串）
 *      2、包装类的静态方法 static String toString(int i) 返回一个表示指定整数的 String 对象
 *      3、String 类的静态方法 static String valueOf(int i) 返回 int 参数的字符串表示形式
 *
 * 字符串（String） -> 基本类型
 *      使用包装类的静态方法 parseXxx("字符串")
 *          Integer 类: static int parseInt(String s)
 *          Double 类: static double parseDouble(String s)
 * */

public class Demo02String {
    public static void main(String[] args) {
        // 基本类型 -> 字符串
        int num01 = 100;
        String str1 = num01 + "";
        System.out.println("str1 + 200 = " + (str1 + 200)); // 100200 而不是 300

        String str2 = Integer.toString(num01);
        System.out.println("str2 + 200 = " + (str2 + 200)); // 100200 而不是 300

        String str3 = String.valueOf(num01);
        System.out.println("str3 + 200 = " + (str3 + 200)); // 100200 而不是 300

        // 字符串（String） -> 基本类型
        String str4 = "100";
        int num02 = Integer.parseInt(str4);
        System.out.println("num02 + 200 = " + (num02 + 200)); // 300 而不是 100200
    }
}
