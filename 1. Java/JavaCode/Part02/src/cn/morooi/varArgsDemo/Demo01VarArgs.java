/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-10 22:10 CST
 */

package cn.morooi.varArgsDemo;

/*
 * 可变参数: JDK 1.5 之后的新特性
 * 使用前提:
 *   当方法的参数列表数据类型已经确定, 但是参数的个数不确定, 就可以使用可变参数
 * 使用格式: 定义方法时使用
 *   修饰符 返回值类型 方法名(数据类型... 变量名){
 *       ...
 *   }
 *
 * 原理:
 *   可变参数底层就是一个数组, 根据传递参数个数不同, 会创建不同长度的数组, 来存储这些参数
 *   传递的参数个数, 可以是 0 个(不传递), 1, 2, ...多个
 *
 * 注意事项:
 *   1. 一个方法的可变参数, 只能有一个可变参数
 *   2. 如果方法的参数有多个, 那么可变参数必须写在参数的末尾
 * */

public class Demo01VarArgs {
    public static void main(String[] args) {
        int result01 = sum(1, 2);
        int result = sumAll(1, 2, 3);
        System.out.println("result = " + result);
    }

    // 定义一个方法, 计算两个 int 类型整数的和
    public static int sum(int a, int b) {
        return a + b;
    }

    // 定义一个方法, 计算 int 类型整数的和
    // 调用 sumAll 就会创建一个数组, 参数有几个长度就是多少
    public static int sumAll(int... array) {
        int result = 0;
        for (int i : array) {
            result += i;
        }

        return result;
    }
}
