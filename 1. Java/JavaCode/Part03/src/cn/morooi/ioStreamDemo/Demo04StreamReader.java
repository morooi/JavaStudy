/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * 字符流:
 * 转换流:
 *   InputStreamReader: 是从字节流到字符流的桥梁
 *       它读取字节, 并使用指定的编码将其解码为字符
 *       它使用的字符集可以由名称指定, 也可以被明确指定, 或者可以接受平台的默认字符集
 *   OutputStreamWriter: 是从字符流到字节流的桥梁
 *       使用指定的编码将写入的字符编码为字节
 *       它使用的字符集可以由名称指定, 也可以被明确指定, 或者可以接受平台的默认字符集
 * */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Demo04StreamReader {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Part03/src/cn/morooi/ioStreamDemo/osw.txt");
        OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        char[] chars = "这是一串字符".toCharArray();
        streamWriter.write(chars, 2, 3);
        streamWriter.flush(); // 刷新流
        streamWriter.close(); // 先刷新, 再关闭流

        InputStreamReader isr =
                new InputStreamReader(new FileInputStream("Part03/src/cn/morooi/ioStreamDemo/osw.txt"), StandardCharsets.UTF_8);
//        int ch;
//        while ((ch = isr.read()) != -1) {
//            System.out.print((char)ch);
//        }
//        isr.close();

        int len;
        char[] cs = new char[1024];
        while ((len = isr.read(cs)) != -1) {
            System.out.print(new String(cs, 0, len));
        }
    }
}
