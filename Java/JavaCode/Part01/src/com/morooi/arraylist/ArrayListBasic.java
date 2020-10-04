/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.arraylist;

/*
 * 如果希望向集合ArrayList中储存基本类型数据，必须使用基本类型对应的"包装类"
 *
 * 基本类型   包装类（引用类型，包装类都位于java.lang包下）
 * byte      Byte
 * short     Short
 * int       Integer     [特殊]
 * long      Long
 * float     Float
 * double    Double
 * char      Character   [特殊]
 * boolean   Boolean
 * */

import java.util.ArrayList;

public class ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();

        // ArrayList<int> listB = new ArrayList<>(); // 错误写法
        ArrayList<Integer> listC = new ArrayList<>(); // 正确写法

    }
}
