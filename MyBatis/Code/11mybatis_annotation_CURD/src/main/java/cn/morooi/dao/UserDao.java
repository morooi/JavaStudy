package cn.morooi.dao;

import cn.morooi.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 在 MyBatis 中针对 CURD 一共有四个注解
 * @Select @Insert @Update @Delete
 */

public interface UserDao {
    /**
     * 查询所有用户, 同时获取到用户下所有账户的信息
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("INSERT INTO user(username, address, sex, birthday) VALUES (#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Update("UPDATE user SET username=#{username}, address=#{address}, sex=#{sex}, birthday=#{birthday} WHERE id=#{id}")
    void updateUserById(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteUserById(Integer id);



}
