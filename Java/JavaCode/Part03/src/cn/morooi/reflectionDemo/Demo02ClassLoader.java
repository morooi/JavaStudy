/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 20:56 CST
 */

package cn.morooi.reflectionDemo;

/*
 * 了解类的加载器
 * */

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo02ClassLoader {
    @Test
    public void test1() {
        // 对于自定义类, 使用系统类加载器进行加载
        ClassLoader classLoader = Demo02ClassLoader.class.getClassLoader();
        System.out.println(classLoader);
        // 调用系统类加载器的 getParent(): 获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        // 调用扩展类加载器的 getParent(): 无法获取引导类加载器
        // 引导类加载器主要负责加载 Java 的核心类库, 无法加载自定义类库
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2); // null
        System.out.println(String.class.getClassLoader()); // null
    }

    /*
     * Properties: 用来读取配置文件
     * */
    @Test
    public void test2() throws IOException {

        Properties prop = new Properties();
        // 此时文件默认在当前的 module 下
        // 读取配置文件的方式一:
//        FileInputStream fileInputStream = new FileInputStream("jdbc1.properties");
//        prop.load(fileInputStream);

        // 读取配置文件的方式二:
        ClassLoader classLoader = Demo02ClassLoader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("jdbc1.properties");
        if (inputStream != null) {
            prop.load(inputStream);
        }

        String name = prop.getProperty("name");
        String password = prop.getProperty("password");
        System.out.println(name);
        System.out.println(password);

        if (inputStream != null) {
            inputStream.close();
        }
//        fileInputStream.close();
    }
}