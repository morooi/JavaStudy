package cn.morooi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain.class, args);
    }
}
