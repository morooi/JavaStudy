package cn.morooi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 */

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping 注解
     * @return
     */
    @RequestMapping(value = "/testRequestMapping", method = {RequestMethod.POST})
    public String testRequestMapping() {
        System.out.println("测试 RequestMapping 注解...");
        return "success";
    }

}
