package cn.morooi.dao.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import cn.morooi.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */

public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    /**
     * 查询所有账户
     *
     * @return 查询到的账户列表
     */
    @Override
    public List<Account> findAllAccount() {
        List<Account> accountList = null;
        try {
            accountList = runner.query(connectionUtils.getThreadLocalConnection(),
                    "SELECT * FROM account", new BeanListHandler<>(Account.class));
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
            account = runner.query(connectionUtils.getThreadLocalConnection(),
                    "SELECT * FROM account WHERE id = ?", new BeanHandler<>(Account.class), accountId);
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
            runner.update(connectionUtils.getThreadLocalConnection(),
                    "INSERT INTO account(name, money) VALUES (?, ?)",
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
            runner.update(connectionUtils.getThreadLocalConnection(),
                    "UPDATE account SET name = ?, money = ? WHERE id = ?",
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
            runner.update(connectionUtils.getThreadLocalConnection(),
                    "DELETE FROM account WHERE id = ?", accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据名称查询账户
     *
     * @param accountName
     * @return 如果有唯一的结果就返回, 如果没有结果返回 null, 多个结果就抛出异常
     */
    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadLocalConnection(),
                    "SELECT * FROM account WHERE name = ?", new BeanListHandler<>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            } else if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一, 数据有误");
            } else {
                return accounts.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
