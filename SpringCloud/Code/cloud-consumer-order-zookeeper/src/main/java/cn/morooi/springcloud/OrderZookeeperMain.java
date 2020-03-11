package cn.morooi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZookeeperMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZookeeperMain.class, args);
    }
}
