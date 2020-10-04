package cn.morooi.service;

import cn.morooi.bean.UserAddress;

import java.util.List;

public interface OrderService {

    /**
     * 初始化订单
     * @param userId
     */
    public List<UserAddress> initOrder(String userId);

}
