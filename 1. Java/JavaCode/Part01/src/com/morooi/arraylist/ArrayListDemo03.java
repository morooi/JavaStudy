/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.arraylist;

import java.util.ArrayList;

public class ArrayListDemo03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        print(list);
    }

    public static void print(ArrayList<Integer> list) {
//        String str = "{" +  + "}"
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.print("{" + list.get(i));
            } else if (i == list.size() - 1) {
                System.out.print("@" + list.get(i) + "}");
            } else {
                System.out.print("@" + list.get(i));
            }
        }
    }
}
