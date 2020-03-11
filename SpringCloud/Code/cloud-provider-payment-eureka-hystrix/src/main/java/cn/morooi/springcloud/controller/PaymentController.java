package cn.morooi.springcloud.controller;

import cn.morooi.springcloud.service.PaymentSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentSerivce paymentSerivce;

    @Value("${server.port}")
    private String severPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentSerivce.paymentInfoOK(id);
        log.info("=== result: " + result + " ===");
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentSerivce.paymentInfoTimeout(id);
        log.info("=== result: " + result + " ===");
        return result;
    }
}
