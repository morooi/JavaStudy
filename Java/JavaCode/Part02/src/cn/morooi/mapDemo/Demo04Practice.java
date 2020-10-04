/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 15:35 CST
 */

package cn.morooi.mapDemo;

/*
 * 计算一个字符串中每个字符出现的次数
 * */

import java.util.HashMap;
import java.util.Scanner;

public class Demo04Practice {
    public static void main(String[] args) {
        System.out.print("输入一个字符串: ");
        String s = new Scanner(System.in).next();
        char[] chars = s.toCharArray();

//        HashMap<Character, Integer> hashMap = new HashMap<>();
////        for (char aChar : chars) {
////            hashMap.put(aChar, null);
////        }
////
////        Set<Character> keySet = hashMap.keySet();
////        for (Character key : keySet) {
////            int count = 0;
////            for (char aChar : chars) {
////                if (key == aChar) {
////                    count += 1;
////                }
////            }
////            hashMap.put(key, count);
////        }
////        System.out.println(hashMap);

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char aChar : chars) {
            if (hashMap.containsKey(aChar)) {
                Integer count = hashMap.get(aChar);
                count++;
                hashMap.put(aChar, count);
            } else {
                hashMap.put(aChar, 1);
            }
        }
        System.out.println(hashMap);
        for (Character c : hashMap.keySet()) {
            System.out.println(c + ": " + hashMap.get(c));
        }
    }
}
