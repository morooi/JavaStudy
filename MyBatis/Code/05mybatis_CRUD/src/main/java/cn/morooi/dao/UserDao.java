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
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 修改/更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据 id 删除用户
     * @param userId
     */
    void deleteUserById(Integer userId);

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
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据 queryVo 中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
