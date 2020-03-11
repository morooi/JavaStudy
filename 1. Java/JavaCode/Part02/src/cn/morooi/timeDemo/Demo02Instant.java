/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 19:56 CST
 */

package cn.morooi.timeDemo;

/*
 * Instant 的使用
 * */

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Demo02Instant {
    @Test
    public void demoInstant() {
        // now(): 获取本初子午线对应的标准时间. (格林威治时间)
        Instant instant = Instant.now();
        System.out.println(instant);

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // toEpochMilli(): 获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数 --> Date类的getTime()
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

        // Instant.ofEpochMilli(): 通过给定的毫秒数, 获取 Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(7583668548113L);
        System.out.println(instant1);
    }
}
