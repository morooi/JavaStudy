package cn.morooi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo07Redirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("重定向前....");
        // 设置响应状态码, 302 重定向
        response.setStatus(302);
        response.setHeader("Location", "form1.html");

        // 推荐使用以下方法重定向
        response.sendRedirect("form1.html");
    }
}
