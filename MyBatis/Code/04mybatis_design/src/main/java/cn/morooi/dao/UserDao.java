package cn.morooi.dao;

import cn.morooi.domain.User;
import cn.morooi.mybatis.annotation.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */

public interface UserDao {
    /**
     * 查询所有操作
     * @return 查询结果
     */
    @Select("SELECT * FROM user")
    List<User> findAll();
}
