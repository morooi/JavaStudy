/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 15:20 CST
 */

package com.morooi.arrays;

/*
* 请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印
* */

import java.util.Arrays;
import java.util.Scanner;

public class ArraysDemo {
    public static void main(String[] args) {
        System.out.print("输入一个字符串：");
        char[] chars = new Scanner(System.in).next().toCharArray();

        Arrays.sort(chars);
        System.out.println("升序排列：" + Arrays.toString(chars));
        System.out.println("倒序打印：");
        for (int i = 1; i <= chars.length; i++) {
            System.out.print(chars[chars.length - i] + ", ");
        }
    }
}
