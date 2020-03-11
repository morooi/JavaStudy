/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 14:57 CST
 */

package cn.morooi.mapDemo;

/*
 * java.util.LinkedHashMap<k, v> 集合 extends HashMap<k, v> 集合
 *    特点:
 *        1. LinkedHashMap 集合底层是哈希表 + 链表 (保证迭代的顺序)
 *        2. LinkedHashMap 集合是一个有序的集合, 存储和取出的顺序是一致的
 * */

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo03LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "a");
        hashMap.put("abc", "abc");
        hashMap.put("ab", "ab");
        hashMap.put("a", "A");

        System.out.println(hashMap); // {a=A, ab=ab, abc=abc} 无序, key 不允许重复

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "a");
        linkedHashMap.put("abc", "abc");
        linkedHashMap.put("ab", "ab");
        linkedHashMap.put("a", "A");

        System.out.println(linkedHashMap); // {a=A, abc=abc, ab=ab} 有序, key 不允许重复
    }
}
