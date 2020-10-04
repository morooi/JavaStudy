package cn.morooi.dao.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    /**
     * 查询所有账户
     *
     * @return 查询到的账户列表
     */
    @Override
    public List<Account> findAllAccount() {
        List<Account> accountList = null;
        try {
            accountList = runner.query("SELECT * FROM account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    /**
     * 根据 id 查询账户
     *
     * @param accountId 账户 ID
     * @return 账户
     */
    @Override
    public Account findAcountById(Integer accountId) {
        Account account = null;
        try {
            account = runner.query("SELECT * FROM account WHERE id = ?", new BeanHandler<>(Account.class), accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    /**
     * 保存账户
     *
     * @param account 被保存的账户
     */
    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("INSERT INTO account(name, money) VALUES (?, ?)",
                    account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
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
            runner.update("UPDATE account SET name = ?, money = ? WHERE id = ?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
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
            runner.update("DELETE FROM account WHERE id = ?", accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
