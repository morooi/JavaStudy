/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-11 20:02 CST
 */

package cn.morooi.throwableDemo;

/*
 * 模拟注册, 如果用户名已存在, 抛出异常提示
 *
 * 分析:
 *   1. 使用数组保存已经注册的用户名
 *   2. 使用 Scanner 获取注册名(前端, 页面)
 *   3. 定义一个方法, 判断
 *       遍历储存已经注册过用户名的数组, 获取每一个用户名
 *       使用获取到的用户名和用户输入的用户名比较
 *           true: 用户名已存在, 抛出异常
 *           false: 继续遍历比较
 *       如果循环结束, 没有重复, 提示"注册成功"
 * */

import java.util.Scanner;

public class DemoRegisterException01 {
    static String[] nameList = {"欧阳娜娜", "古力娜扎", "迪丽热巴", "马尔扎哈"};

    public static void main(String[] args) /*throws RegisterException*/ {

        System.out.println("输入用户名: ");
        String inputName = new Scanner(System.in).next();

        checkName(inputName);
    }

    private static void checkName(String inputName) /*throws RegisterException*/ {
        for (String s : nameList) {
            if (s.equals(inputName)) {
                try {
                    throw new RegisterException("已被注册");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return; // 结束方法
                }
            }
        }

        System.out.println("注册成功");
    }
}
