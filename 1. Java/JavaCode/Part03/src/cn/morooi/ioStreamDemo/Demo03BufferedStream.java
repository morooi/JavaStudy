/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * 字节缓冲流:
 *   字节缓冲输入流: BufferedInputStream(InputStream in)
 *   字节缓冲输出流: BufferedOutputStream(OutputStream out)
 * */

import java.io.*;

public class Demo03BufferedStream {
    public static void main(String[] args) throws IOException {
        // 字节缓冲输出流: BufferedOutputStream(OutputStream out)
        FileOutputStream fos = new FileOutputStream("Part03/src/cn/morooi/ioStreamDemo/buffer_test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        bos.write("Hello\n".getBytes());
        bos.write("World\n".getBytes());

        bos.close();

        // 字节缓冲输入流: BufferedInputStream(OutputStream out)
        FileInputStream fis = new FileInputStream("Part03/src/cn/morooi/ioStreamDemo/buffer_test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 一次读取一个字节
        int i;
        while ((i = bis.read()) != -1) {
            System.out.print((char)i);
        }
        // 一次读取一个字节数组
        int len;
        byte[] bys = new byte[1024];
        while ((len = bis.read(bys)) != -1) {
            System.out.println(new String(bys, 0, len));
        }
        bis.close();
    }
}
