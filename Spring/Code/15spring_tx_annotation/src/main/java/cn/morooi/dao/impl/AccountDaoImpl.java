package cn.morooi.dao.impl;

import cn.morooi.dao.AccountDao;
import cn.morooi.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 账户的持久层实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accountList = jdbcTemplate.query("SELECT * FROM account where id = ?",
                new BeanPropertyRowMapper<>(Account.class), accountId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accountList = jdbcTemplate.query("SELECT * FROM account where name = ?",
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
        jdbcTemplate.update("UPDATE account SET name = ?, money = ? WHERE id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
