package cn.morooi.service.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import cn.morooi.service.AccountService;
import cn.morooi.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_OLD implements AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

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
        List<Account> accounts = null;
        try {
            transactionManager.beginTransaction();
            accounts = accountDao.findAllAccount();
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.releaseTransaction();
        }
        return accounts;
    }

    /**
     * 根据 id 查询账户
     *
     * @param accountId 账户 ID
     * @return 账户
     */
    @Override
    public Account findAcountById(Integer accountId) {
        Account acount = null;
        try {
            transactionManager.beginTransaction();
            acount = accountDao.findAcountById(accountId);
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.releaseTransaction();
        }

        return acount;
    }

    /**
     * 保存账户
     *
     * @param account 被保存的账户
     */
    @Override
    public void saveAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.saveAccount(account);
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.releaseTransaction();
        }
    }

    /**
     * 更新账户
     *
     * @param account 要更新的账户
     */
    @Override
    public void updateAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.updateAccount(account);
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.releaseTransaction();
        }
    }

    /**
     * 根据账户 id 删除账户
     *
     * @param accountId 要删除的账户 ID
     */
    @Override
    public void deleteAccountById(Integer accountId) {
        try {
            transactionManager.beginTransaction();
            accountDao.deleteAccountById(accountId);
            transactionManager.commitTransaction();
        } catch (Exception e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.releaseTransaction();
        }
    }

    /**
     * 账户间转账
     *
     * @param sourceName 转出账户名称
     * @param targeName  转入账户名称
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targeName, Double money) {
        try {
            transactionManager.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targeName);
            if (source.getMoney() < money) {
                throw new RuntimeException("账户 " + source.getName() + " 余额不足");
            } else {
                source.setMoney(source.getMoney() - money);
                target.setMoney(target.getMoney() + money);
                accountDao.updateAccount(source);
                accountDao.updateAccount(target);
            }
            transactionManager.commitTransaction();
        } catch (RuntimeException e) {
            transactionManager.rollbackTransaction();
            e.printStackTrace();
        } finally {
            transactionManager.releaseTransaction();
        }
    }
}
