/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.diGuiDemo;

/*
 * 递归解决问题要找到两个内容:
 *   递归出口: 否则会出现内存溢出
 *   递归规则: 与原问题相似的规模较小的问题
 * */

public class DiGuiDemo01 {
    public static void main(String[] args) {
        // 回顾不死神兔问题, 假设一对初生兔子要一个月才到成熟期，而一对成熟兔子每月会生一对兔子
        // 那么，由一对初生兔子开始，20 个月后会有多少对兔子
        // 每个月的兔子对数: 1, 1, 2, 3, 5, 8, ....
        int[] list = new int[20];

        list[0] = 1;
        list[1] = 1;

        for (int i = 2; i < list.length; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        System.out.println(list[19]);

        int i = countRabbit(20);
        System.out.println(i);
    }

    // 递归解决问题, 首先要定义一个方法:
    //      定义一个方法 f(n): 表示第 n 个月的兔子对数
    public static int countRabbit(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else
            return countRabbit(n - 1) + countRabbit(n - 2);
    }
}
