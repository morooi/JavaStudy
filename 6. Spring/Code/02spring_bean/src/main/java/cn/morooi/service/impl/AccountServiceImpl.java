package cn.morooi.service.impl;

import cn.morooi.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {

    }

    public void saveUser() {
        System.out.println("serivce 中的 saveAccount 方法执行了");
    }

    public void init() {
        System.out.println("对象初始化了....");
    }

    public void destory() {
        System.out.println("对象销毁了....");
    }
}
