/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.random;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(50) + 1;

/*        // 写法1
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个数字：");
        int inputNum = scanner.nextInt();

        while (inputNum != num) {
            if (inputNum < num) {
                System.out.println("小了");
            } else {
                System.out.println("大了");
            }
            System.out.print("输入一个数字：");
            inputNum = scanner.nextInt();
        }

        System.out.printf("猜中了！数字是：%d，你猜的是%d", num, inputNum);*/

        // 写法2（更优）
        for (int i = 1; i <= 10; i++) {
            System.out.print("\n输入一个数字(1-50之间)：");
            int inputNum = new Scanner(System.in).nextInt();

            if (inputNum < 1 || inputNum > 50){
                System.out.printf("输入错误！请输入1-50之间的数字！还有%d次机会！\n", 10 - i);
            } else if (inputNum == num) {
                System.out.printf("恭喜你，答对啦！共用次数%d次\n", i);
                System.out.println("游戏结束！");
                break;
            } else if (inputNum < num) {
                System.out.printf("小了，还有%d次机会！\n", 10 - i);
            } else {
                System.out.printf("大了，还有%d次机会！\n", 10 - i);
            }
        }
    }
}
