/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * 流的分类:
 *   1. 操作数据单位: 字节流, 字符流
 *   2. 数据的流向: 输入流, 输出流
 *   3. 流的角色: 节点流, 控制流
 *
 * 流的体系结构
 *   抽象基类               节点流(或文件流)               缓冲流(处理流的一种)
 *   InputStream           FileInputStream             BufferedInputStream
 *   OutputStream          FileOutputStream            BufferedOutputStream
 *   Reader                FileReader                  BufferedReader
 *   Writer                FileWriter                  BufferedWriter
 * */

/*
 * FileOutputStream: 文件输出流, 用于将数据写入 file
 *   FileOutputStream(String name): 创建文件输出流以指定的名称写入文件
 *   FileOutputStream(String name, boolean append): 创建文件输出流以指定的名称写入文件, 如果第二个参数为 true 则写入到文件末尾
 *   FileOutputStream(File file): 创建文件输出流以写入由指定的 File 对象表示的文件
 *   FileOutputStream(File file, boolean append): 创建文件输出流以写入由指定的 File 对象表示的文件, 如果第二个参数为 true 则写入到文件末尾
 *
 * 写数据的三种方式:
 *   void write(int b): 将指定的字节写入此文件输出流
 *   void write(byte[] b): 将 b.length 字节从指定的字节数组写入此文件输出流
 *   void write(byte[] b, int off, int len): 将 len 字节从指定的字节数组开始, 从偏移量 off 开始写入此文件输出流
 *
 * 实现换行:
 *   windows: \r\n
 *   linux: \n
 *   mac: \r
 *
 * */

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01FileOutputStream {
    public static void main(String[] args) throws IOException {
        /*
         * 创建字节输出流对象, 做了个三件事:
         *      1. 调用系统功能创建了文件
         *      2. 创建了字节输出流对象
         *      3. 让字节输出流对象指向创建好的文件
         * */
        FileOutputStream fos = new FileOutputStream("Part03/src/cn/morooi/ioStream/test.txt");
        // void write(int b): 将指定的字节写入此文件输出流
        fos.write(97);

        // void write(byte[] b): 将 b.length 字节从指定的字节数组写入此文件输出流
        byte[] bytes = {95, 96, 97};
        fos.write(bytes);
        // 或
        byte[] str = "你说".getBytes();
        fos.write(str);

        // void write(byte[] b, int off, int len): 将 len 字节从指定的字节数组开始, 从偏移量 off 开始写入此文件输出流
        byte[] str2 = "asdasdfisdifnsd".getBytes();
        fos.write(str2, 1, 4);

        // 换行 "\r" 换行符
        fos.write("\rabc".getBytes());

        // 最后都要释放资源
        // void close(): 关闭此文件输出流并释放与此流相关联的任何系统资源
        fos.close();

        // 追加
        FileOutputStream fos2 = new FileOutputStream("Part03/src/cn/morooi/ioStream/test.txt", true);
        fos2.write("这是追加的".getBytes());
        fos2.close();
    }
}
