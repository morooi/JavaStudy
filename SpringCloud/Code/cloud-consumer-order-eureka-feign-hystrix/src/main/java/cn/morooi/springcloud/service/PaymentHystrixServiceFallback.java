package cn.morooi.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "-----PaymentHystrixServiceFallback paymentInfoOK-----";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-----PaymentHystrixServiceFallback paymentInfoTimeout-----";
    }
}
