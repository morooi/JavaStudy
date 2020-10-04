/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-06 20:40 CST
 */

package cn.morooi.dateDemo;

/*
* java.util.Date: 表示日期和时间的类
* 类Date表示特定的瞬间，精确到毫秒
* 1000 毫秒 = 1 秒
*
* 时间原点：1970-01-01 00:00:00 GMT (格林尼治标准时间)
*         1970-01-01 08:00:00 CST (中国标准时间)
* */

public class Demo01Date {
    public static void main(String[] args) {
        // 获取当前系统时间到1970-01-01 00:00:00 GMT经历了多少毫秒
        System.out.println(System.currentTimeMillis()); // 1581228513223
    }
}
