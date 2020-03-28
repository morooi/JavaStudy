package cn.morooi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody // 这个类的所有方法返回的数据直接写给浏览器(如果是对象转为 json 数据)*/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World Quick!";
    }
}
