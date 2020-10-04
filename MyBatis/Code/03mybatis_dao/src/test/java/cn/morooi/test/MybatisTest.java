package cn.morooi.test;

import cn.morooi.dao.UserDao;
import cn.morooi.dao.impl.UserDaoImpl;
import cn.morooi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        // 3. 使用工厂创建 dao 对象
        UserDaoImpl userDao = new UserDaoImpl(factory);
        // 4. 使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // 6. 释放资源
        inputStream.close();
    }
}
