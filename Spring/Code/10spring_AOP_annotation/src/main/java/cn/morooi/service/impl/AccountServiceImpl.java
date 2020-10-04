package cn.morooi.service.impl;

import cn.morooi.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    /**
     * 模拟保存账户
     */
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    /**
     * 模拟更新账户
     *
     * @param i
     */
    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新 " + i);
    }

    /**
     * 模拟删除账户
     */
    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
