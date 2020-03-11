package cn.morooi.dao.impl;

import cn.morooi.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDaoImpl1")
public class AccountDaoImpl implements AccountDao {
    public void saveAccount() {
        System.out.println("用户已保存_1");
    }
}
