package cn.morooi.springcloud.controller;

import cn.morooi.springcloud.entities.CommonResult;
import cn.morooi.springcloud.entities.Payment;
import cn.morooi.springcloud.service.PaymentSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentSerivce paymentSerivce;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentSerivce.create(payment);
        log.info("===== 插入结果: " + result + " =====");

        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功，serverPort：" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentSerivce.getPaymentById(id);
        log.info("===== 查询结果: " + payment + " =====");

        if (payment != null) {
            return new CommonResult<>(200, "查询成功，serverPort：" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录，查询 id: " + id, null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("=== element：" + element + " ===");
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + " " + instance.getHost() + " " + instance.getPort() + " " + instance.getUri());
        }

        return this.discoveryClient;

    }

    @GetMapping("/zk")
    public String paymentzk() {
        return "Spring Cloud with Zookeeper: " + serverPort + ", " + UUID.randomUUID().toString();
    }

}
