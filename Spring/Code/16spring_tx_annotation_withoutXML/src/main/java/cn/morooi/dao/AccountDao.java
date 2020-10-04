package cn.morooi.dao;

import cn.morooi.domain.Account;

/**
 * 账户的持久层接口
 */

public interface AccountDao {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
