/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * 使用 FileReader FileWriter
 * */

import java.io.*;

public class Demo05Copy {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            FileReader fileReader = new FileReader("Part03/src/cn/morooi/ioStream/StreamReader.java");
            FileWriter fileWriter = new FileWriter("Part03/src/cn/morooi/ioStream/StreamReader_copy.java");

//        char[] chars = new char[1024];
//        int len;
//        while ((len = fileReader.read(chars)) != -1) {
//            fileWriter.write(chars, 0, len);
//        }
//        fileReader.close();
//        fileWriter.close();

            // 使用字符缓冲流
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//        char[] chars = new char[1024];
//        int len;
//        while ((len = bufferedReader.read(chars)) != -1) {
//            bufferedWriter.write(chars, 0, len);
//        }
//        bufferedReader.close();
//        bufferedWriter.close();

            // 使用字符缓冲流特有功能
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
