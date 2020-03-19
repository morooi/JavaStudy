package cn.morooi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class Demo04HttpServletRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post 请求要设置字符集, 要在获取请求参数之前才有效
        request.setCharacterEncoding("utf-8");

        // getParameter()：获取请求的参数
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        // getParameterValues()：获取请求的参数(多个值的时候使用)
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // 请求转发
        System.out.println("转发前: " + username);
        // setAttribute(key, value)：设置域数据
        request.setAttribute("key", "柜台1的章");
        // getRequestDispatcher()：获取请求转发对象
        request.getRequestDispatcher("/httpServletRequest2").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getRequestURI()：获取请求的资源路径
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        // getRequestURL()：获取请求的统一资源定位符（绝对路径）
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        // getRemoteHost()：获取客户端的 ip 地址
        String remoteHost = request.getRemoteHost();
        System.out.println("remoteHost = " + remoteHost);
        // getHeader()：获取请求头
        String header = request.getHeader("User-Agent");
        System.out.println("header = " + header);
        // getMethod：获取请求的方式 GET 或 POST
        String method = request.getMethod();
        System.out.println("method = " + method);
    }
}
