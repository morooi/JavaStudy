package cn.morooi.controller;

import cn.morooi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("userController")
@RequestMapping("/user")
public class UserController {

    /**
     * 返回字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("方法 testString 执行了.....");
        // 模拟从数据库查询出 User 对象
        User user = new User();
        user.setUsername("特朗普");
        user.setPassword("pswd");
        user.setAge(18);
        // Model 对象
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回类型为 void
     * @param request
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("方法 testVoid 执行了.....");
//        // 请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
//        // 重定向
//        response.sendRedirect(request.getContextPath() + "index.jsp");
        // 直接进行响应
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print("三等奖");
    }

    /**
     * 返回 ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("方法 testModelAndView 执行了.....");
        // 创建 ModelAndView 对象
        ModelAndView mv = new ModelAndView();
        // 模拟从数据库查询出 User 对象
        User user = new User();
        user.setUsername("奇偶暗示的");
        user.setPassword("222sas");
        user.setAge(22);

        // 把 user 对象存储到 mv 中, 也会把 user 对象存入到 request 对象
        mv.addObject("user", user);

        // 跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(Model model) {
        System.out.println("方法 testForwardOrRedirect 执行了.....");

//        // 请求的转发
//        return "forward:/WEB-INF/pages/success.jsp";
        // 重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("方法 testAjax 执行了.....");
        // 客户端发送 ajax 请求, 传的是 json 字符串, 后端把 json 字符串封装到 user 对象中
        System.out.println(user);
        // 做响应, 模拟查询数据库
        user.setUsername("阿速达的");
        user.setAge(30);
        // 做响应
        return user;
    }
}
