/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 16:03 CST
 */

package cn.morooi.calendarDemo;

/*
 * Calendar 类的常用成员方法
 *      public int get(int field): 返回给定日历字段的值
 *      public void set(int field, int value): 将给定的日历字段设置为给定值
 *      public abstract void add(int field, int amount): 根据日历的规则，为给定的日历字段添加或减去指定的时间量
 *      public Date getTime(): 返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象
 * 成员方法的参数：
 *      int field: 日历类的字段，可以使用Calendar类的静态成员变量获取
 *          public static final int YEAR = 1;           年
 *          public static final int MONTH = 2;          月
 *          public static final int DATE = 5;           月中的某一天
 *          public static final int DAY_OF_MONTH = 5;   月中的某一天
 *          public static final int HOUR = 10;          时
 *          public static final int MINUTE = 12;        分
 *          public static final int SECOND = 13;        秒
 * */

import java.util.Calendar;
import java.util.Date;

public class Demo02Calendar {
    public static void main(String[] args) {
        demoGet();
        System.out.println("==========");
        demoSet();
        System.out.println("==========");
        demoAdd();
        System.out.println("==========");
        demoGetTime();
    }

    /*
     * public int get(int field): 返回给定日历字段的值
     * 参数：
     *  int field: 传递指定的日历字段（YEAR, MONTH, ...）
     * 返回值：日历字段代表的具体的值
     * */
    private static void demoGet() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date01 = c.get(Calendar.DATE);
        int date02 = c.get(Calendar.DAY_OF_MONTH);

        System.out.println("YEAR = " + year);
        System.out.println("MONTH = " + month); // 西方的月：0-11
        System.out.println("DATE = " + date01);
        System.out.println("DAY_OF_MONTH = " + date02);
    }

    /*
     * public void set(int field, int value): 将给定的日历字段设置为给定值
     * 参数：
     *   int field: 传递指定的日历字段（YEAR, MONTH, ...）
     *   int value: 给指定字段设置值
     * */
    private static void demoSet() {
        Calendar c = Calendar.getInstance();
        System.out.println("set前：YEAR = " + c.get(Calendar.YEAR));

        c.set(Calendar.YEAR, 2000);
        System.out.println("set后：YEAR = " + c.get(Calendar.YEAR));

        // set()的重载，同时设置年月日
        c.set(2000, 8, 8);
        System.out.printf("YEAR = %d, MONTH = %d, DATE = %d\n",
                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));
    }

    /*
     * public abstract void add(int field, int amount): 根据日历的规则，为给定的日历字段添加或减去指定的时间量
     * 把指定的字段增加/减少指定的值
     *
     * 参数：
     *  int field: 传递指定的日历字段（YEAR, MONTH, ...）
     *  int amount: 增加/减少指定的值
     *      正数：增加
     *      负数：减少
     * */
    private static void demoAdd() {
        Calendar c = Calendar.getInstance();
        // 把年增加3年
        c.add(Calendar.YEAR, 3);
        // 把月增加4月
        c.add(Calendar.MONTH, 4);
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
    }

    /*
     * public Date getTime(): 返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象
     * */
    private static void demoGetTime() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println(date);
    }
}
