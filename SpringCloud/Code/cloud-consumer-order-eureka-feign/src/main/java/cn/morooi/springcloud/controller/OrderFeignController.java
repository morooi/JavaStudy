package cn.morooi.springcloud.controller;

import cn.morooi.springcloud.entities.CommonResult;
import cn.morooi.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon 默认等待 1 秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
