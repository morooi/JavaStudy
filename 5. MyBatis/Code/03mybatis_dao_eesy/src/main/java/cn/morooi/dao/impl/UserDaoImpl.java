package cn.morooi.dao.impl;

import cn.morooi.dao.UserDao;
import cn.morooi.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        // 1. 使用工厂创建 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        // 使用 Session 执行查询方法
        List<User> userList = sqlSession.selectList("cn.morooi.dao.UserDao.findAll");
        sqlSession.close();
        // 返回查询结果
        return userList;
    }
}
