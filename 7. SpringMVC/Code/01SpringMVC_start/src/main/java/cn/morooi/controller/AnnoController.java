package cn.morooi.controller;

import cn.morooi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) // 存到 Session 域
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable String id) {
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("执行了...");
        System.out.println(cookie);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute 执行了...");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法先执行
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser 执行了...");
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setBirthday(new Date());
        map.put("abc", user);
    }

//    /**
//     * 该方法先执行
//     */
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser 执行了...");
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setBirthday(new Date());
//        return user;
//    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes 执行了...");
        // 底层会存储到 request 域对象中
        model.addAttribute("msg", "马上到");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes 执行了...");
        String msg = (String)modelMap.getAttribute("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除值
     * @param
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("getSessionAttributes 执行了...");
        status.setComplete();
        return "success";
    }


}
