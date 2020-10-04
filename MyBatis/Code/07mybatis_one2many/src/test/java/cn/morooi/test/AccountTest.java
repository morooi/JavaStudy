package cn.morooi.test;

import cn.morooi.dao.AccountDao;
import cn.morooi.dao.UserDao;
import cn.morooi.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream inputStream = null;
    private SqlSession sqlSession = null;
    private AccountDao accountDao = null;

    @Before // 用于在测试方法执行之前执行
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
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
    public void findAllTest() {
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
