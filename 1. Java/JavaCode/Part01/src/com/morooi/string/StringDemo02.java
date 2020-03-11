/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 13:56 CST
 */

package com.morooi.string;

/*
 * 题目：键盘输入一个字符串，并且统计其中各种字符出现的次数。
 * 种类有：大写字母，小写字母，数字，其他
 * */

import java.util.Scanner;

public class StringDemo02 {
    public static void main(String[] args) {
        System.out.print("请输入一个字符串：");
        String input = new Scanner(System.in).next();

        int upCase = 0;
        int lowCase = 0;
        int num = 0;
        int other = 0;

        char[] chars = input.toCharArray();

        for (char aChar : chars) {
            if ('A' <= aChar && aChar <= 'Z') {
                upCase++;
            } else if ('a' <= aChar && aChar <= 'z') {
                lowCase++;
            } else if ('0' <= aChar && aChar <= '9') {
                num++;
            } else {
                other++;
            }
        }

        System.out.printf("该字符串共有大写字母%d个，小写字母%d个，数字%d个，其他%d个", upCase, lowCase, num, other);
    }
}
