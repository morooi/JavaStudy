/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-06 21:00 CST
 */

package cn.morooi.dateDemo;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
    }

    /*
     * Date 类的空参数构造方法
     * Date() 获取当前系统的日期和时间
     * */
    private static void demo01() {
        Date date = new Date();
        System.out.println(date); // Sun Feb 09 14:05:18 CST 2020
    }

    /*
     * Date 类的带参数构造方法
     * Date(long date): 传递毫秒值，把毫秒值转换成Date日期
     * */
    private static void demo02() {
        Date date = new Date(1581228513223L);
        System.out.println(date); // Sun Feb 09 14:08:33 CST 2020
    }

    /*
     * long getTime(): 把日期转换为毫秒值（相当于System.currentTimeMillis()方法）
     *  返回自 1970-01-01 00:00:00 GMT 以来, 此 Date 对象表示的毫秒数
     * */
    private static void demo03() {
        Date date = new Date();
        long nowDate = date.getTime();
        System.out.println(nowDate);
    }

    /*
     * java.util.Data 转换为 java.sql.Date
     * */
    private static void demo04() {
        Date date1 = new Date(1934234632423L);
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }
}
