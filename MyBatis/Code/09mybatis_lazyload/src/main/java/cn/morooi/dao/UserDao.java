package cn.morooi.dao;

import cn.morooi.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户, 同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据 id 查找用户
     * @param userId
     * @return
     */
    User findUserById(Integer userId);
}
