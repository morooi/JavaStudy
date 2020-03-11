package cn.morooi.service.impl;

import cn.morooi.bean.UserAddress;
import cn.morooi.service.OrderService;
import cn.morooi.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @DubboReference
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }
}
