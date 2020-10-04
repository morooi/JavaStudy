package cn.morooi.service;

import cn.morooi.bean.UserAddress;

import java.util.List;

public interface UserService {

    /**
     * 按照用户id返回所有的收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);

}
