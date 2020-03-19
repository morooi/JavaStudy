package cn.morooi.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Demo01HelloMyServlet implements Servlet {

    public Demo01HelloMyServlet() {
        System.out.println("1. 构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. init 初始化");
        // 获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("servletConfig.getServletName() = " + servletConfig.getServletName());
        // 获取初始化参数 init-param
        System.out.println("servletConfig.getInitParameter(\"username\") = "
                + servletConfig.getInitParameter("username"));
        System.out.println("servletConfig.getInitParameter(\"url\") = " + servletConfig.getInitParameter("url"));
        // 获取 ServletContext 对象
        System.out.println("servletConfig.getServletContext() = " + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * serice 方法专门用于处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 HelloMyServlet 被访问");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
//            System.out.println(method);
            doGet();
        } else if ("POST".equals(method)) {
//            System.out.println(method);
            doPost();
        }
    }

    private void doGet() {
        System.out.println("GGGGGGET");
    }

    private void doPost() {
        System.out.println("PPPPPOST");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 销毁");
    }
}
