package cn.morooi.test;

import cn.morooi.dao.UserDao;
import cn.morooi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private InputStream inputStream = null;
    private SqlSession sqlSession = null;
    private UserDao userDao = null;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destory() throws IOException {
        // 提交事务
        sqlSession.commit();

        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache() {
        User user1 = userDao.findUserById(41);
        System.out.println(user1);

        sqlSession.clearCache(); // 手动清空缓存

        User user2 = userDao.findUserById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testClearCache() {
        // 1. 查询用户
        User user1 = userDao.findUserById(41);
        System.out.println(user1);

        // 2. 更新用户信息
        user1.setUsername("炸弹");
        user1.setAddress("计算技术计算机");

        // 3. 更新数据库
        userDao.updateUser(user1);

        User user2 = userDao.findUserById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }
}
