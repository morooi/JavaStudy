package cn.morooi.springcloud.controller;

import cn.morooi.springcloud.entities.CommonResult;
import cn.morooi.springcloud.entities.Payment;
import cn.morooi.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001/payment";
    public static final String PAYMENT_URL = "http://cloud-provider-payment/payment";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/get/" + id, CommonResult.class);
    }

    @GetMapping("/get-entity/{id}")
    public CommonResult getPaymentByIdEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/get/" + id, CommonResult.class);
        log.info(entity.getStatusCode().toString());
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败（来自 consumer）");
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        URI uri = instance.getUri();
        log.info(uri.toString());
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
