package cn.morooi.springcloud;

import cn.morooi.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-provider-payment", configuration = MySelfRule.class)
public class OrderEurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderEurekaMain.class, args);
    }
}
