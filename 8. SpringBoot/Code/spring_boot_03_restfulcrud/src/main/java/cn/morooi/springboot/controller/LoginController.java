package cn.morooi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            session.setAttribute("loginUser", username);
            // 登录成功, 防止表单重复提交, 可重定向到主页
            return "redirect:/main";
        } else {
            // 登录失败
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
