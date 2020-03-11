/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * 读取文件中的内容:
 *
 * FileInputStream(String name): 从文件系统中的文件获取输入字节
 *
 * 步骤:
 *   1. 创建字节输入流对象
 *   2. 调用字节输入流对象的读数据方法
 *   3. 释放资源
 *
 * 异常使用 try-catch-finally 处理
 * */

import java.io.FileInputStream;
import java.io.IOException;

public class Demo02FileInputStream {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("Part03/src/cn/morooi/ioStreamDemo/test.txt");

        // 调用字节输入流对象的读数据方法
        // int read(): 从该输入流读取一个字节的数据, 如果达到文件末尾, 则为 -1
//        int read = fis.read();
//        System.out.println(read);
//        System.out.println((char)read);

        // 读取全部
//        int by = fis.read();
//        while (by != -1) {
//            System.out.print((char)by);
//            by = fis.read();
//        }

        // 优化上面的程序
        int by2;
        while ((by2 = fis.read()) != -1) {
            System.out.print((char)by2);
        }
        fis.close();

        System.out.println("----------");
        FileInputStream fis2 = new FileInputStream("Part03/src/cn/morooi/ioStreamDemo/test.txt");
        // int read(byte[] b): 从该输入流读取最多 b.length 个字节的数组到一个字节数组, 返回值是读取的字节数
//        byte[] bytes = new byte[5];
//        int len = fis2.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes, 0, len));
        // 读取全部
        int length;
        byte[] bys = new byte[1024];
        while ((length=fis2.read(bys)) != -1) {
            System.out.print(new String(bys, 0, length));
        }

        // 释放资源
        fis2.close();

    }
}
