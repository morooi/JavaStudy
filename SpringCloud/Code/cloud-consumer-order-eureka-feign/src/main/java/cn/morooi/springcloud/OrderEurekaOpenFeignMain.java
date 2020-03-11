package cn.morooi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderEurekaOpenFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderEurekaOpenFeignMain.class, args);
    }
}
