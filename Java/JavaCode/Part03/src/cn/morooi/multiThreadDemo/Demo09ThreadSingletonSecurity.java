/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.multiThreadDemo;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */

public class Demo09ThreadSingletonSecurity {

}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    // 线程不安全
    public static Bank getInstance1() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    // 线程安全
    public static Bank getInstance2() {
        if (instance == null) {
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;
    }

    // 线程安全且效率更高
    public static Bank getInstance3() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}