package cn.morooi.service;

import cn.morooi.domain.Account;

/**
 * 账户业务层接口
 */

public interface AccountService {
    /**
     * 根据 id 查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
