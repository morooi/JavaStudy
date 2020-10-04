/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 14:57 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * RandomAccessFile 类的使用
 *   1. RandomAccessFile 直接继承与 java.lang.Object 类, 实现了 DataInput 和 DataOutput 接口
 *   2. RandomAccessFile 既可以作为一个输入流, 又可以作为一个输出流
 *   3. 如果 RandomAccessFile 作为输出流时, 写出到的文件如果不存在, 则在执行过程中自动创建
 *      如果写出到的文件存在, 则会对原有文件内容进行覆盖. (默认情况下, 从头覆盖)
 * */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo09RandomAccessFile {

    @Test
    public void RandomAccessFileTest1() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile1 = new RandomAccessFile("src/cn/morooi/ioStreamDemo/osw.txt", "r");
            randomAccessFile2 = new RandomAccessFile("src/cn/morooi/ioStreamDemo/oswCopy.txt", "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFile1.read(bytes)) != -1) {
                randomAccessFile2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert randomAccessFile1 != null;
                randomAccessFile1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert randomAccessFile2 != null;
                randomAccessFile2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void RandomAccessFileTest2() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/cn/morooi/ioStreamDemo/oswCopy.txt", "rw");
            randomAccessFile.write("xys".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert randomAccessFile != null;
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void RandomAccessFileTest3() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/cn/morooi/ioStreamDemo/oswCopy.txt", "rw");
            randomAccessFile.seek(3); // 将指针调到角标为 3 的位置
            randomAccessFile.write("xys".getBytes()); // 覆盖
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert randomAccessFile != null;
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 使用 RandomAccessFile 实现数据的插入效果
     * */
    @Test
    public void RandomAccessFileTest4() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/cn/morooi/ioStreamDemo/oswCopy.txt", "rw");
            randomAccessFile.seek(3); // 将指针调到角标为 3 的位置
            // 保存指针 3 后面的所有数据到 StringBuilder 中
            StringBuilder sb = new StringBuilder((int)new File("src/cn/morooi/ioStreamDemo/oswCopy.txt").length());
            byte[] bytes = new byte[1024];
            int len;
            while ((len = randomAccessFile.read(bytes)) != -1) {
                sb.append(new String(bytes, 0 ,len));
            }

            randomAccessFile.seek(3);
            randomAccessFile.write("xyz".getBytes());
            randomAccessFile.write(sb.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert randomAccessFile != null;
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
