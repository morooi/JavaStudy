/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.diGuiDemo;

/*
 * 递归求阶乘
 * */

public class DiGuiDemo02 {
    public static void main(String[] args) {
        System.out.println(jieCheng(5));
    }

    public static int jieCheng(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * jieCheng(n - 1);
        }
    }

}
