package cn.morooi.controller;

import cn.morooi.domain.Account;
import cn.morooi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */

@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定的入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username) {
        System.out.println("执行了...." + username);
        return "success";
    }

    /**
     * 请求参数吧绑定:把数据封装到 JavaBean 的类中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了保存账户....");
        System.out.println(account);
        return "success";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("执行了保存用户....");
        System.out.println(user);
        return "success";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了....");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
