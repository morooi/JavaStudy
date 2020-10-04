/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 16:18 CST
 */

package cn.morooi.netDemo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 例子: 客户端发送信息给服务端, 服务端将数据显示在控制台上
 * */

public class Demo02TCPTest {
    // 客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream stream = null;
        try {
            // 1. 创建 Socket 对象, 指明服务器端的 ip 和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8888);
            // 2. 获取一个输出流, 用于输出数据
            stream = socket.getOutputStream();
            // 3. 写出数据的操作
            stream.write("你哈呀, 阿萨德hi撒谎in建安大厦".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert stream != null;
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 服务端
    @Test
    public void server() {
        Socket accept = null;
        InputStream inputStream = null;
        ServerSocket serverSocket = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1. 创建服务器端的 ServerSocket, 指明自己的端口号
            serverSocket = new ServerSocket(8888);
            // 2. 调用 accept() 表示接收来自于客户端的 socket
            accept = serverSocket.accept();
            // 3. 获取输入流
            inputStream = accept.getInputStream();

//            // 不建议, 可能有乱码
//            byte[] bytes = new byte[1024];
//            int len;
//            while ((len = inputStream.read(bytes)) != -1) {
//                String s = new String(bytes, 0, len);
//                System.out.println(s);
//            }
            // 4. 读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println(serverSocket.getInetAddress().getHostAddress());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            try {
                assert accept != null;
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert byteArrayOutputStream != null;
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
