package cn.morooi.dao;

import cn.morooi.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在 MyBatis 中针对 CURD 一共有四个注解
 * @Select @Insert @Update @Delete
 */

@CacheNamespace(blocking = true) // 使用二级缓存
public interface UserDao {
    /**
     * 查询所有用户, 同时获取到用户下所有账户的信息
     * @return
     */
    @Select("SELECT * FROM user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(column = "id", property = "accounts",
                    many = @Many(select = "cn.morooi.dao.AccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
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

    @Select("SELECT * FROM user WHERE id = #{id}")
    @ResultMap(value = {"userMap"})
    User findUserById(Integer id);
}
