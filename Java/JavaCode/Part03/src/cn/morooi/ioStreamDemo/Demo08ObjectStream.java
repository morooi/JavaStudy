/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-10 22:19 CST
 */

package cn.morooi.ioStreamDemo;

/*
 * 对象流的使用:
 *   1. ObjectInputStream 和 ObjectOutputStream
 *   2. 作用: 用于存储和读取基本数据类型数据或对象的处理流.
 *      它的强大之处就是可以把 Java 中的对象写入到数据源中, 也能把对象从数据源中还原回来
 *   3. 要想一个 java 对象是可序列化的, 需要满足相应的要求. 见 Person.java
 *
 * 序列化机制:
 *      对象序列化机制允许把内存中的 Java 对象转换成平台无关的二进制流, 从而允许把这种
 *      二进制流持久地保存在磁盘上, 或通过网络将这种二进制流传输到另一个网络节点,
 *      当其它程序获取了这种二进制流, 就可以恢复成原来的Java对象.
 * */

import org.junit.jupiter.api.Test;

import java.io.*;

public class Demo08ObjectStream {

    /*
     * 序列化过程: 将内存中的 java 对象保存到磁盘中或通过网络传输出去
     * 使用 ObjectOutputStream 实现
     * */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/cn/morooi/ioStreamDemo/object.dat"));
            oos.writeObject(new String("什么鬼?"));
            oos.flush(); // 刷新操作

            oos.writeObject(new Person("张伟", 44));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * 反序列化过程: 将磁盘文件中的对象还原为内存中的一个 java 对象
     * 使用 ObjectInputStream 实现
     * */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/cn/morooi/ioStreamDemo/object.dat"));
            Object object = ois.readObject();
            String s = (String)object;
            System.out.println(s);

            Person person = (Person)ois.readObject();
            System.out.println(person);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
