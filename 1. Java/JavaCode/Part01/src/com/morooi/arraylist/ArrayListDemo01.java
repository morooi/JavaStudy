/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.arraylist;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            int randomNum = new Random().nextInt(33) + 1;
            list.add(randomNum);
        }

        System.out.println(list);
    }
}
