package cn.morooi.test;

import cn.morooi.domain.Account;
import cn.morooi.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用 JUnit 单元测试: 测试我们的配置
 */

public class AccountServiceTest {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    private AccountService accountSerive = ac.getBean("accountService", AccountService.class);

    @Test
    public void testFindAllAccount() {
        List<Account> accountList = accountSerive.findAllAccount();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        Account acount = accountSerive.findAcountById(1);
        System.out.println(acount);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("萨迪哦");
        account.setMoney(10000.0);
        accountSerive.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = accountSerive.findAcountById(5);
        account.setName("哦");
        account.setMoney(8000.0);
        accountSerive.updateAccount(account);
    }

    @Test
    public void testDeleteAccountById() {
        accountSerive.deleteAccountById(5);
    }
}
