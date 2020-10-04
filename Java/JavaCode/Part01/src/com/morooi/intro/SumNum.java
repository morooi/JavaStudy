/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.intro;

import java.util.Scanner;

public class SumNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入一个数字：");
        int inputNum = in.nextInt();

        sum(inputNum);
    }

    private static void sum(int inputNum) {
        if (inputNum < 0)
            System.out.println("数字必须大于0");
        else {
            int n = 0;
            for (int i = 0; i <= inputNum; i++) {
                n = n + i;
            }
            System.out.println("结果：" + n);
        }
    }


}
