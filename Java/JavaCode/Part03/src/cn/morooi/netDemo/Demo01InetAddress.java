/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 16:07 CST
 */

package cn.morooi.netDemo;


/*
 * 在 Java 中使用 InetAddress 类代表 IP
 *
 * 如何实例化 InetAddress:
 *  两个方法:
 *    getByName(String host), getLocalHost()
 *  两个常用的方法: getHostName(), getHostAddress()
 * */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01InetAddress {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.1.1");
            System.out.println(byName);

            InetAddress name = InetAddress.getByName("morooi.cn");
            System.out.println(name);

            InetAddress local = InetAddress.getByName("127.0.0.1");
            System.out.println(local);

            // 获取本地 ip
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            // getHostName(), getHostAddress()
            System.out.println(name.getHostName());
            System.out.println(name.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
