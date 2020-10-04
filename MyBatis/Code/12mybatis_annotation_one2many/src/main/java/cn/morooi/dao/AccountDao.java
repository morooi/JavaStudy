package cn.morooi.dao;

import cn.morooi.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户并获取每个账户所属的用户信息
     *
     * @return
     */
    @Select("SELECT * FROM account")
    @Results(id = "accountMap", value = {
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "UID", property = "uid"),
            @Result(column = "MONEY", property = "money"),
            @Result(property = "user", column = "UID",
                    one = @One(select = "cn.morooi.dao.UserDao.findUserById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    @Select("SELECT * FROM account WHERE UID = #{id}")
    List<Account> findAccountByUid();
}
