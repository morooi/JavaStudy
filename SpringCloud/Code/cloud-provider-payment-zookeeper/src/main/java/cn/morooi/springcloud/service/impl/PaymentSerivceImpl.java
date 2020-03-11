package cn.morooi.springcloud.service.impl;

import cn.morooi.springcloud.dao.PaymentDao;
import cn.morooi.springcloud.entities.Payment;
import cn.morooi.springcloud.service.PaymentSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentSerivceImpl implements PaymentSerivce {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
