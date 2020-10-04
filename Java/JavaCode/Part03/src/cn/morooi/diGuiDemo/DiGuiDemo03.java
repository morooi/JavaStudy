/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-08 22:03 CST
 */

package cn.morooi.diGuiDemo;

/*
 * 用递归完成遍历该目录下的所有内容, 并把所有文件的绝对路径输出到控制台
 * */

import java.io.File;
import java.util.Objects;

public class DiGuiDemo03 {
    public static void main(String[] args) {
        File part03 = new File("Part03");
        getAllFilePath(part03);
    }

    public static void getAllFilePath(File file) {
        for (File listFile : Objects.requireNonNull(file.listFiles())) {
            if (listFile.isDirectory()) {
                getAllFilePath(listFile);
            } else {
                System.out.println(listFile.getAbsoluteFile());
            }
        }
    }
}
