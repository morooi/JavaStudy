/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.intro;

import java.util.Scanner;

public class SameNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入第一个数字：");
        int num1 = in.nextInt();

        System.out.println("输入第二个数字：");
        int num2 = in.nextInt();

        isNumSame(num1, num2);
    }

    private static void isNumSame(int a, int b) {
        if (a == b)
            System.out.println("两数字相等！");
        else
            System.out.println("两数字不同！");
    }
}
