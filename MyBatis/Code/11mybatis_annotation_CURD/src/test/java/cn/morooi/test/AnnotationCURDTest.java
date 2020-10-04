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
import java.util.Date;

public class AnnotationCURDTest {

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

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("爱妾");
        user.setAddress("上海市");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.saveUser(user);
    }

    @Test
    public void testUpdateUserById() {
        User user = new User();
        user.setId(45);
        user.setUsername("弟弟");
        user.setAddress("台北市");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUserById(user);
    }


    @Test
    public void testDeleteUserById() {
        userDao.deleteUserById(50);
    }
}
