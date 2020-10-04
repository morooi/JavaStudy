/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

/*
 * 题目：
 * 用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中。
 * */

package com.morooi.arraylist;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo04 {

    public static void main(String[] args) {
        ArrayList<Integer> listBig = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            listBig.add(new Random().nextInt(100));
        }

        ArrayList<Integer> listSmall = findOdds(listBig);


        System.out.println("大集合：" + listBig);
        System.out.println("小集合：" + listSmall);
    }


    public static ArrayList<Integer> findOdds(ArrayList<Integer> list) {
        ArrayList<Integer> listSmall = new ArrayList<>();

        for (int n : list) {
            if (n % 2 == 0) {
                listSmall.add(n);
            }
        }
        return listSmall;
    }
}