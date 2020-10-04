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

public class SecondLevelCacheTest {

    private InputStream inputStream = null;
    private SqlSessionFactory sessionFactory = null;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After // 用于在测试方法执行之后执行
    public void destory() throws IOException {
        // 提交事务
//        sqlSession.commit();

        // 关闭资源
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testFirstLevelCache() {
        SqlSession sqlSession1 = sessionFactory.openSession();
        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);

        User user1 = userDao1.findUserById(41);
        System.out.println(user1);
        sqlSession1.close(); // 一级缓存消失

        SqlSession sqlSession2 = sessionFactory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);

        User user2 = userDao2.findUserById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }

}
