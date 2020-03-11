package cn.morooi.springcloud.controller;

import cn.morooi.springcloud.entities.CommonResult;
import cn.morooi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-provider-payment/payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(INVOKE_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(INVOKE_URL + "/get/" + id, CommonResult.class);
    }

}
