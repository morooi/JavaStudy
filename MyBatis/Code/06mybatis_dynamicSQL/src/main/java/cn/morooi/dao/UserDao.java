package cn.morooi.dao;

import cn.morooi.domain.QueryVo;
import cn.morooi.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据 id 查找用户
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * 根据名称模糊查找用户
     * @param username
     * @return
     */
    List<User> findUserByName(String username);

    /**
     * 根据 queryVo 中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @param user 查询的条件: 有可能有用户名, 性别, 地址, 都有 或 都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据 queryvo 中提供的 id 集合, 查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
