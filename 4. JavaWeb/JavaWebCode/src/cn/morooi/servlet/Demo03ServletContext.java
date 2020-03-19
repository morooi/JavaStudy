package cn.morooi.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo03ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 1. 获取 web.xml 中配置的上下文参数 context-param
//        ServletContext servletContext = getServletConfig().getServletContext();
//        String username = servletContext.getInitParameter("username");
//        System.out.println(username);
//        // 2. 获取当前的工程路径，格式：`/工程路径`
//        String contextPath = servletContext.getContextPath();
//        System.out.println(contextPath);
//        // 3. 获取工程部署后在服务器硬盘上的绝对路径
//        String realPath = servletContext.getRealPath("/");
//        System.out.println(realPath);

        // 4. 像 Map 一样存取数据
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("key1", "value1");

        Object key1 = servletContext.getAttribute("key1");
        System.out.println(key1);
    }
}
