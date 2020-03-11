/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 15:00 CST
 */

package cn.morooi.dateDemo;

/*
 * 计算一个人出生了多少天
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Demo04LiveDays {
    public static void main(String[] args) throws ParseException {
        System.out.print("请输入你的生日（格式：xxxx-xx-xx）：");
        String birthday = new Scanner(System.in).next();
        ArrayList<Integer> live = caculateDays(birthday);
        System.out.printf("已出生 %d 天，现在你有 %d 岁", live.get(0), live.get(1));
    }

    private static ArrayList<Integer> caculateDays(String birthday) throws ParseException {
        // 获取当前时间毫秒值
        long nowTime = new Date().getTime();
        // 解析生日的毫秒值
        long firstDay = new SimpleDateFormat("yyyy-MM-dd").parse(birthday).getTime();
        int liveDays = (int)((nowTime - firstDay) / 1000 / 60 / 60 / 24);
        int liveYears = (int)((nowTime - firstDay) / 1000 / 60 / 60 / 24 / 365); // 没有考虑闰年
        ArrayList<Integer> live = new ArrayList<>();
        live.add(liveDays);
        live.add(liveYears);

        return live;
    }
}
