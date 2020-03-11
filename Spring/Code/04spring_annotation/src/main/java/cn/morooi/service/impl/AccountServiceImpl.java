package cn.morooi.service.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 */

@Component
@Scope("prototype")
public class AccountServiceImpl implements AccountService {
//    @Autowired
//    @Qualifier(value = "accountDaoImpl2")
    @Resource(name = "accountDaoImpl1")
    private AccountDao accountDao = null;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
