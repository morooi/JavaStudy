package cn.morooi.test;

import cn.morooi.dao.AccountDao;
import cn.morooi.dao.UserDao;
import cn.morooi.domain.Account;
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

public class AnnotationTest {

    private InputStream inputStream = null;
    private SqlSession sqlSession = null;
    private AccountDao accountDao = null;
    private UserDao userDao = null;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
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
    public void testAcountFindAll() {
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println("===========");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testUserFindAll() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println("=========");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
