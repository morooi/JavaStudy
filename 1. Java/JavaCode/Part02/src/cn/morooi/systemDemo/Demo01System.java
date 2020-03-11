/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-02-09 16:22 CST
 */

package cn.morooi.systemDemo;

/*
 * java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作
 *
 * 常用操作有：
 *   public static long currentTimeMillis(): 返回以毫秒为单位的当前时间
 *   public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length):
 *       将数组中指定的数据拷贝到另一个数组中
 * */

import java.util.Arrays;

public class Demo01System {
    public static void main(String[] args) {
        demoCurrentTimeMillis();
        System.out.println("========");
        demoArraycopy();
    }

    /*
     * 用来验证程序的效率
     *   验证for循环打印数字1-9999所需要使用的时间（毫秒）
     * */
    private static void demoCurrentTimeMillis() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            System.out.println(i + 1);
        }
        long endTime = System.currentTimeMillis();
        long passTime = endTime - startTime;
        System.out.println("共用时" + passTime + "毫秒");
    }

    /*
     * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length):
     *       将数组中指定的数据拷贝到另一个数组中
     *
     * 参数：
     *  Object src: 源数组
     *  int srcPos: 源数组中的起始位置(起始索引)
     *  Object dest: 目标数组
     *  int destPos: 目标数据中的起始位置
     *  int length: 要复制的数组元素的数量
     *
     * 练习：
     *  将src数组中前3个元素，复制到dest数组的前3个位置上
     *      复制元素前：  src: [1, 2, 3, 4, 5]    dest: [6, 7, 8, 9, 10]
     *      复制元素后：  src: [1, 2, 3, 4, 5]    dest: [1, 2, 3, 9, 10]
     * */
    private static void demoArraycopy() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println("原src:" + Arrays.toString(src));
        System.out.println("原dest:" + Arrays.toString(dest));
        System.arraycopy(src, 0, dest, 0, 3);
        System.out.println("src:" + Arrays.toString(src));
        System.out.println("dest:" + Arrays.toString(dest));
    }
}
