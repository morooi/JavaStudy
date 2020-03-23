package cn.morooi.dao;

import cn.morooi.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 */

public interface UserDao {
    /**
     * 查询所有操作
     * @return 查询结果
     */
    List<User> findAll();
}
