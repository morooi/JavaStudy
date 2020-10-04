package cn.morooi.service.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.dao.impl.AccountDaoImpl;
import cn.morooi.service.AccountService;

public class AccountServiceImpl implements AccountService {
    public void saveUser() {
        AccountDao accountDao = new AccountDaoImpl();
        accountDao.saveUser();
    }
}
