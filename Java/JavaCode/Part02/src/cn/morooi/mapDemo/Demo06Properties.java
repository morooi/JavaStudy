/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-09 21:53 CST
 */

package cn.morooi.mapDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo06Properties {
    public static void main(String[] args) throws IOException {
        // 用来处理配置文件, key 和 value 都是 String 类型
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("Part03/jdbc.properties");
        properties.load(fileInputStream);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name = " + name + " password = " + password);
    }
}
