/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-02 15:40 CST
 */

package cn.morooi.stringBuilderDemo;

/*
 * String 类：
 *      字符串是常量，他们的值在创建后不能更改
 *      字符串的底层是一个被final修饰的数组，不能改变，是一个常量
 *      private final byte[] value;
 *
 * StringBuilder 类：
 *      字符串缓冲区，可以提高字符串的操作效率（看成是一个长度可变的字符串）
 *      底层也是一个数组，但是没有被final修饰，可以改变长度
 *      byte[] value = new byte[16];
 *
 * StringBuilder 构造方法：
 *      public StringBuilder(): 构造一个不带任何字符的字符串生成器，其初始容量为16字符
 *      public StringBuilder(int capacity): 指定容量
 *      public StringBuilder(String str): 构造一个字符串生成器，并初始化为指定的字符串内容
 *
 * StringBuilder 常用方法：
 *      public StringBuilder append(...): 添加任意类型数据的字符串形式，并返回当前对象自身
 *      public StringBuilder insert(int offset, xxx): 在指定位置插入 xxx
 *      public StringBuilder delete(int start, int end): 删除指定位置的内容, 左闭右开区间
 *      public StringBuilder replace(int start, int end, String str): 把 [start, end) 位置替换为 str
 *      public StringBuilder reverse(): 把当前字符序列逆转
 *      public String toString(): 将当前StringBuilder对象转换为String对象
 *      public String substring(int start, ine end)
 *      public int length()
 *      public char charAt(int n)
 *      public void setCharAt(int n, char ch)
 * */

public class Demo01String {
    public static void main(String[] args) {
        appendDemo();
        System.out.println("============");
        toStringDemo();
    }

    private static void appendDemo() {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder("Hello World");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("===========");
        // append方法返回的是this，调用方法的对象（无需接收返回值）
        StringBuilder str3 = str1.append("Hello World");
        System.out.println("str1: " + str1);
        System.out.println("str3: " + str3);
        System.out.println("str1 == str3: " + (str1 == str3)); // 比较的是地址，true
        System.out.println("str2 == str3: " + (str2 == str3)); // 比较的是地址，false
        System.out.println("============");
        // 链式编程：方法返回值是一个对象
        // 可以接收任何值
        str1.append(1).append("实打实").append(true).append(0.2);
        System.out.println("str1: " + str1);
    }


    private static void toStringDemo() {
        String str1 = "Hello";
        System.out.println("str = " + str1);

        StringBuilder str2 = new StringBuilder(str1);
        str2.append(" !!!");
        System.out.println("str2 = " + str2);

        String str3 = str2.toString();
        System.out.println("str3 = " + str3);
    }
}
