package cn.morooi.springboot;

import cn.morooi.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * Spring Boot 单元测试
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器
 */

@SpringBootTest
class SpringBoot01HelloworldQuickApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ac;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void testHelloService() {
        boolean b = ac.containsBean("helloService");
        System.out.println(b);
    }

}
