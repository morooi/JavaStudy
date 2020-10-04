/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-07 12:09 CST
 */

package com.morooi.intro;

public class OverLoad {
    public static void main(String[] args) {
        System.out.println(isSame((byte) 10, (byte) 20));
        System.out.println(isSame(10, 10));
        System.out.println(isSame((float) 10, (float) 20));
        System.out.println(isSame((short) 10, (short) 10));
    }

    public static boolean isSame(byte a, byte b) {
        return a == b;
    }

    public static boolean isSame(int a, int b) {
        return a == b;
    }

    public static boolean isSame(float a, float b) {
        return a == b;
    }

    public static boolean isSame(short a, short b) {
        return a == b;
    }

}
