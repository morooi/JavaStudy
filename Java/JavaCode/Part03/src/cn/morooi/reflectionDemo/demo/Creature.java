/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 22:27 CST
 */

package cn.morooi.reflectionDemo.demo;

import java.io.Serializable;

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    private void eat() {
        System.out.println("生物吃东西");
    }
}
