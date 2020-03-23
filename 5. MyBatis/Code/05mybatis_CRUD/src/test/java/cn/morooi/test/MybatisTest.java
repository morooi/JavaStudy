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
import java.util.Date;
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
        InputStream resource = null;
        SqlSession session = null;
        try {
            resource = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resource);
            session = sessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);
            List<User> userList = userDao.findAll();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (resource != null) {
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试保存方法
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("厉害了");
        user.setUserAddress("北京第三军区交通委");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println("保存操作前 " + user);
        userDao.saveUser(user);
        System.out.println("保存操作后 " + user);
    }

    /**
     * 测试更新方法
     */
    @Test
    public void testUpdateUser() {
        User user = new User();

        user.setUserId(41);
        user.setUserName("特朗普");
        user.setUserAddress("北京交通委");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    /**
     * 测试删除方法
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUserById(46);
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
     * 查询总用户数
     */
    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
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
}


