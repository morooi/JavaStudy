package cn.morooi.service.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import cn.morooi.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 查询所有账户
     *
     * @return 查询到的账户列表
     */
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    /**
     * 根据 id 查询账户
     *
     * @param accountId 账户 ID
     * @return 账户
     */
    @Override
    public Account findAcountById(Integer accountId) {
        return accountDao.findAcountById(accountId);
    }

    /**
     * 保存账户
     *
     * @param account 被保存的账户
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /**
     * 更新账户
     *
     * @param account 要更新的账户
     */
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 根据账户 id 删除账户
     *
     * @param accountId 要删除的账户 ID
     */
    @Override
    public void deleteAccountById(Integer accountId) {
        accountDao.deleteAccountById(accountId);
    }
}
