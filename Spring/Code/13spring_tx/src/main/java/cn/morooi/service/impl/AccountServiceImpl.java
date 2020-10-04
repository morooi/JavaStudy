package cn.morooi.service.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import cn.morooi.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 根据 id 查询账户
     *
     * @param accountId
     * @return
     */
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        if (source.getMoney() < money) {
            throw new RuntimeException("账户 " + source.getName() + " 余额不足");
        } else {
            source.setMoney(source.getMoney() - money);
//            int i = 1 / 0;
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
        }
    }
}
