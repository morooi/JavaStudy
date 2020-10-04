package cn.morooi.test;

import cn.morooi.dao.UserDao;
import cn.morooi.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 测试 MyBatis 的 crud 操作
 */

public class MybatisTest {

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
    public void testFindAll() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试通过 id 查询 User
     */
    @Test
    public void testFindUserById() {
        User user = userDao.findUserById(50);
        System.out.println(user);
    }

    /**
     * 测试通过 name 模糊查询 User
     */
    @Test
    public void testFindUserByName() {
        List<User> users = userDao.findUserByName("%王%");
//        List<User> users = userDao.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试使用 QueryVo 作查询条件
     */
    @Test
    public void testFindUserByVo() {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        queryVo.setUser(user);
        List<User> users = userDao.findUserByVo(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    /**
     * 测试使用  作查询条件
     */
    @Test
    public void testFindUserByCondition() {
        User user = new User();
        user.setUserName("小二王");
        user.setSex("女");
        List<User> users = userDao.findUserByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindUserInIds() {
        QueryVo queryVo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(45);
        list.add(51);
        queryVo.setIds(list);
        List<User> users = userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
