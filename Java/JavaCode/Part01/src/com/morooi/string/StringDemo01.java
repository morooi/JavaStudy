/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 13:45 CST
 */

package com.morooi.string;

/*
 * 定义一个方法，把数组{1, 2, 3}按照指定格式拼接成一个字符串。格式参照如下：[word1#word2#word3]
 * */

import java.util.ArrayList;

public class StringDemo01 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        String newArray = contact(array);
        System.out.println(newArray);
    }

    public static String contact(int[] array) {
        String newArray = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                newArray += "word" + array[i] + "]";
            } else {
                newArray += "word" + array[i] + "#";
            }
        }
        return newArray;
    }
}
