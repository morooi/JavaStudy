package cn.morooi.springboot.config;

import cn.morooi.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    // 将方法的返回值添加到容器中, 容器中这个组件默认的 id 就是方法名
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
