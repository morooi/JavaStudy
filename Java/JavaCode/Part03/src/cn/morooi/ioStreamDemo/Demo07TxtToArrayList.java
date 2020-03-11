/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.ioStreamDemo;

/*
* 把文本文件中的数据读取到集合中, 要求每一行数据是一个集合元素
* */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Demo07TxtToArrayList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Part03/src/cn/morooi/ioStream/list.txt"));
        ArrayList<String> list = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        bufferedReader.close();
        System.out.println(list);
    }
}
