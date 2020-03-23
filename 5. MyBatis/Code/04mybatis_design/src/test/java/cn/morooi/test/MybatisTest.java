package cn.morooi.test;

import cn.morooi.dao.UserDao;
import cn.morooi.domain.User;
import cn.morooi.mybatis.io.Resources;
import cn.morooi.mybatis.sqlsession.SqlSession;
import cn.morooi.mybatis.sqlsession.SqlSessionFactory;
import cn.morooi.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MyBatis 的入门案例
 */

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SQLSessionFactory 工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 使用工厂生产 SQLSession 对象
        SqlSession sqlSession = factory.openSession();
        // 4. 使用 SQLSession 创建 Dao 接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5. 使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // 6. 释放资源
        sqlSession.close();
        inputStream.close();
    }
}
