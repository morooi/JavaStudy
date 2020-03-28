package cn.morooi.dao.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

/**
 * 账户的持久层实现类
 */

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accountList = super.getJdbcTemplate().query("SELECT * FROM account where id = ?",
                new BeanPropertyRowMapper<>(Account.class), accountId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accountList = super.getJdbcTemplate().query("SELECT * FROM account where name = ?",
                new BeanPropertyRowMapper<>(Account.class), accountName);
        if (accountList.size() > 1) {
            System.out.println("结果不唯一");
        } else if (accountList.isEmpty()) {
            return null;
        }
        return accountList.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("UPDATE account SET name = ?, money = ? WHERE id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
