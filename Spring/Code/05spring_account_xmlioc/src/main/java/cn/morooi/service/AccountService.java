package cn.morooi.service;

import cn.morooi.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */

public interface AccountService {
    /**
     * 查询所有账户
     * @return 查询到的账户列表
     */
    List<Account> findAllAccount();

    /**
     * 根据 id 查询账户
     * @param accountId 账户 ID
     * @return 账户
     */
    Account findAcountById(Integer accountId);

    /**
     * 保存账户
     * @param account 被保存的账户
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account 要更新的账户
     */
    void updateAccount(Account account);

    /**
     * 根据账户 id 删除账户
     * @param accountId 要删除的账户 ID
     */
    void deleteAccountById(Integer accountId);
}
