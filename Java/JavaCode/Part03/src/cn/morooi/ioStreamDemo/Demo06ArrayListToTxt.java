/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
* 把 ArrayList 集合中的字符串数据写入到文本文件中, 要求每一个字符串作为文件中的一行数据
* */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Demo06ArrayListToTxt {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("ZSJ");

        BufferedWriter writer = new BufferedWriter(new FileWriter("Part03/src/cn/morooi/ioStream/list.txt"));
        for (String s : list) {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }
        writer.close();
    }
}
