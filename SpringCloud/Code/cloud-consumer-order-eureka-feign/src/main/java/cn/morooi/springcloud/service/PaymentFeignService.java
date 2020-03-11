package cn.morooi.springcloud.service;

import cn.morooi.springcloud.entities.CommonResult;
import cn.morooi.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "cloud-provider-payment")
@RequestMapping("/payment")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    String paymentFeignTimeout();

}
