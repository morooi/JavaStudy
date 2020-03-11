package cn.morooi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain.class, args);
    }
}
