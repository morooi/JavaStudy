package cn.morooi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo06HttpServletResponse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 设置服务器字符集为 UTF-8
//        response.setCharacterEncoding("UTF-8");
//        // 通过设置响应头设置浏览器字符集
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");

        // setContentType() 同时设置服务器和客户端都使用 UTF-8, 而且设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html; charset=UTF-8");

        // 发送数据
        PrintWriter writer = response.getWriter();
        writer.write("返回一个字符串");
    }
}
