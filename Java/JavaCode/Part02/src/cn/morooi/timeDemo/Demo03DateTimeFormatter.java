/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 21:01 CST
 */

package cn.morooi.timeDemo;

/*
 * 格式化或解析日期, 时间
 *       类似于 SimpleDateFormat
 * */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class Demo03DateTimeFormatter {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        // 方式一: 预定义的标准格式. 如: ISO_LOCAL_DATE_TIME
        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化: 日期 --> 字符串
        String format = isoLocalDate.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);
        // 解析: 字符串 --> 日期
        System.out.println(isoLocalDate.parse("2020-03-08T20:03:54.411359"));

        /*
         * 方式二: 本地化相关的格式.
         *   如: ofLocalizedDateTime()
         *      FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT: 适用于 LocalDateTime
         *   如: ofLocalizedDate()
         *      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT: 适用于 LocalDate
         * */
        DateTimeFormatter ofLocalizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String format1 = ofLocalizedDateTime.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format1);

        DateTimeFormatter ofLocalizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format2 = ofLocalizedDate.format(localDateTime);
        System.out.println(format2);

        // 方式三: 自定义的格式. 如: ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format3 = ofPattern.format(localDateTime);
        System.out.println(format3);
        // 解析
        String str = "2020-03-08 09:00:45";
        TemporalAccessor parse = ofPattern.parse(str);
        System.out.println(parse);
    }
}
