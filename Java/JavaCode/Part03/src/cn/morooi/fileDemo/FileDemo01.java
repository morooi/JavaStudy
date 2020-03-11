/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.fileDemo;

/*
 * File: 文件和目录路径名的抽象表示
 *   1. 文件和目录是可以通过 File 封装成对象的
 *   2. 对 File 而言, 其封装的并不是一个真正存在的文件, 仅仅是一个路径名而已.
 *
 * 构造方法:
 *   File(String pathname): 通过将给定的路径名字符串转换为抽象路径名来创建新的 File 实例
 *   File(String parent, String child): 从父路径名字符串和子路径名字符串创建新的 File 实例
 *   File(File parent, String child): 从父抽象路径名和子路径名字符串创建新的 File 实例
 * */

import java.io.File;

public class FileDemo01 {
    public static void main(String[] args) {
        File file1 = new File("/Users/morooi/Download/1.txt");
        System.out.println(file1);

        File file2 = new File("/Users/morooi/Download", "1.txt");
        System.out.println(file2);

        File file3 = new File("/Users/morooi/Download");
        File file4 = new File(file3, "1.txt");
        System.out.println(file4);
    }
}
