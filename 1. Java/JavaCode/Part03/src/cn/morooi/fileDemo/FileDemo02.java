/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.fileDemo;

/*
 * File 类创建功能:
 *   public boolean createNewFile(): 当具有该名称的文件不存在时, 创建一个由该抽象路径名命名的新空文件
 *       如果不存在, 就创建文件, 并返回 true
 *       如果存在, 就不创建文件, 并返回 false
 *   public boolean mkdir(): 创建由此抽象路径名命名的目录
 *       如果不存在, 就创建目录, 并返回 true
 *       如果存在, 就不创建目录, 并返回 false
 *   public boolean mkdirs(): 创建由此抽象路径名命名的目录, 包括任何必需但不存在的父目录
 *       如果不存在, 就创建目录, 并返回 true
 *       如果存在, 就不创建目录, 并返回 false
 * */

import java.io.File;
import java.io.IOException;

public class FileDemo02 {
    public static void main(String[] args) throws IOException {
        File file = new File("Part03/src/cn/morooi/file/test.txt");
        System.out.println(file.createNewFile());

        File folder = new File("Part03/src/cn/morooi/file/test1");
        System.out.println(folder.mkdir());

        File folder2 = new File("Part03/src/cn/morooi/file/test2/HTML");
        System.out.println(folder2.mkdirs());
    }
}
