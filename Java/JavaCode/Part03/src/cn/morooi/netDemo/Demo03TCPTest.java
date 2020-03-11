/*
 * Copyright (c) 2020
 * @Author: morooi
 * @Email: morooiu@gmail.com
 * @LastModified: 2020-03-11 16:36 CST
 */

package cn.morooi.netDemo;

/*
 * 实现 TCP 的网络编程
 *
 * 客户端发送文件给服务端, 服务端将文件保存在本地, 并返回给客户端: "发送成功"
 * */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo03TCPTest {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        try {
            // 1.
            socket = new Socket(InetAddress.getByName("localhost"), 8888);
            // 2.
            outputStream = socket.getOutputStream();
            // 3.
            fileInputStream = new FileInputStream("src/cn/morooi/netDemo/new.txt");
            // 4.
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            // 5.
            socket.shutdownOutput();
            // 6. 接收服务器端的信息
            inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1 = inputStream.read(bytes1)) != -1) {
                byteArrayOutputStream.write(bytes1, 0, len1);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert socket != null;
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fileInputStream != null;
                fileInputStream.close();
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

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            // 1.
            serverSocket = new ServerSocket(8888);
            // 2.
            socket = serverSocket.accept();
            // 3.
            inputStream = socket.getInputStream();
            // 4.
            fileOutputStream = new FileOutputStream("src/cn/morooi/netDemo/new_1.txt");
            // 5.
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            System.out.println("传输完成");
            // 6. 服务器端返回信息
            outputStream = socket.getOutputStream();
            outputStream.write("已收到".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert socket != null;
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
