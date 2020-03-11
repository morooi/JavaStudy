/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 14:37 CST
 */

package cn.morooi.dateDemo;

/*
 * java.text.DateFormat: 是日期/时间格式化子类的抽象类
 * 作用：
 *   格式化（日期 -> 文本）、解析（文本 -> 日期）
 * 成员方法：
 *   String format(Date date): 按照指定的模式，把Date日期，格式化为符合模式的字符串
 *   Date parse(String source): 把符合模式的字符串，解析为Date日期
 *
 * DateFormat类是一个抽象类，无法直接创建对象，可以使用DateFormat类的子类
 * java.text.DateFormat.SimpleDateFormat
 * 构造方法：
 *   SimpleDateFormat(String pattern):
 *       用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat
 *       参数：String pattern（传递指定的模式）
 *       模式：区分大小写
 *           y   年
 *           M   月
 *           d   日
 *           H   时
 *           m   分
 *           s   秒
 *       写对应的模式，会把模式替换为对应的日期和时间："yyyy-MM-dd HH:mm:ss"
 *                                          或 "yyyy年MM月dd日 HH时mm分ss秒"
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo03DateFormat {
    public static void main(String[] args) throws ParseException {
        demo01();
        demo02();
    }

    /*
     * 使用DateFormat类中的方法format()，把日期格式化为文本
     * */
    private static void demo01() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(date);           // Sun Feb 09 14:30:01 CST 2020
        System.out.println(s.format(date)); // 2020-02-09 14:30:01
    }

    /*
     * 使用DateFormat类中的方法parse()，把文本格式化为日期
     * */
    private static void demo02() throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(s.parse("2020-02-09 14:30:01")); // Sun Feb 09 14:30:01 CST 2020
    }


}
