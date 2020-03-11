package cn.morooi.springcloud.service;

import cn.morooi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentSerivce {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
