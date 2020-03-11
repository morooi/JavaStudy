package cn.morooi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class UserServiceProviderBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootApplication.class, args);
    }

}
