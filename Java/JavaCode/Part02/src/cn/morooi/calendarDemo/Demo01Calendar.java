/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 19:09 CST
 */

package cn.morooi.calendarDemo;

/*
 * java.util.Calendar 是一个抽象类，里面提供了很多操作日历字段的方法(YEAR, MONTH, DAY_OF_MONTH, HOUR)
 * Calendar类无法直接创建对象使用，可以使用静态方法getInstance()，该方法返回了Calendar类的子类对象
 *
 * static Calendar getInstance(): 使用默认时区和语言环境获得一个日历
 * */

import java.util.Calendar;

public class Demo01Calendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }
}
