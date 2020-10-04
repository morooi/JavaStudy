/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 19:17 CST
 */

package cn.morooi.wrapperClassDemo;

/*
 * 包装类（wrapper class）：
 *
 * 装箱：把基本类型的数据，包装到包装类中（基本类型的数据 -> 包装类）
 *  构造方法：(以 int -> Integer 为例)
 *      Integer(int value): 构造一个新的Integer对象，表示指定的int值
 *      Integer(String s): 构造一个新的Integer对象，表示String参数所指示的int值
 *          传递的字符串必须是基本类型的字符串，否则会抛出异常
 *  静态方法：
 *      static Integer valueOf(int i): 返回一个表示指定int值的Integer实例
 *      static Integer valueOf(String s): 返回保存指定的String值得Integer对象
 *
 * 拆箱：在包装类中取出基本类型的数据（包装类 -> 基本类型的数剧）
 *  成员方法：
 *      int intValue(): 以int类型返回该Integer的值
 * */

public class Demo01WrapperClass {
    public static void main(String[] args) {
        // 装箱
        Integer int1 = new Integer(1); // 已过时
        System.out.println("int1 = " + int1);

        Integer int2 = new Integer("2"); // 已过时
        System.out.println("int2 = " + int2);

        Integer int3 = Integer.valueOf(3);
        System.out.println("int3 = " + int3);

        Integer int4 = Integer.valueOf("4");
        System.out.println("int4 = " + int4);

//        Integer int5 = Integer.valueOf("a"); // 错误写法，NumberFormatException 数字格式化异常

        // 拆箱
        int int6 = int1.intValue();
        System.out.println("int6 = " + int6);

        // 自动装箱
        Integer int7 = 5; // 相当于 Integer int7 = new Integer(5);

        // 自动拆箱
        int int8 = int7 + 1; // 相当于 int int8 = int7.intValue() + 1;
    }
}
