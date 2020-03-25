package cn.morooi.dao.impl;

import cn.morooi.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDaoImpl2")
public class AccountDaoImpl2 implements AccountDao {
    public void saveAccount() {
        System.out.println("用户已保存_2");
    }
}
