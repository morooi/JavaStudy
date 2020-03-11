package cn.morooi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableHystrix
public class PaymentEurekaHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentEurekaHystrixMain.class, args);
    }
}
