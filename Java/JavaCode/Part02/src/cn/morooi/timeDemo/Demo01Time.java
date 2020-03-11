/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 19:45 CST
 */

package cn.morooi.timeDemo;

/*
 * LocalDate, LocalTime, LocalDateTime 的使用
 * 说明:
 *    1. LocalDateTime 相较于 LocalDate, LocalTime 使用频率要高
 *    2. 类似于 Calendar
 * */


import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Demo01Time {
    @Test
    public void demoTime() {
        // now(): 获取当前的日期, 时间, 日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of(): 设置指定的年, 月, 日, 时, 分, 秒. 没有偏移量
        LocalDateTime time = LocalDateTime.of(2020, 3, 8, 19, 38, 21);
        System.out.println(time);

        // getXxx(): 获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getHour());

        // 体现了不可变性
        // withXxx(): 修改相关属性
        LocalDateTime dayOfMonth = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(dayOfMonth);

        // plusXxx()
        LocalDateTime localDateTime1 = localDateTime.plusDays(20);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        // minusXxx()
        LocalDateTime localDateTime2 = localDateTime.minusHours(30);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
    }
}
