package cn.morooi.test;

import cn.morooi.domain.Account;
import cn.morooi.service.AccountService;
import config.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * 使用 JUnit 单元测试: 测试我们的配置
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

//    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//    private ApplicationContext ac =  new AnnotationConfigApplicationContext(SpringConfiguration.class);
//    private AccountService accountSerive = ac.getBean("accountService", AccountService.class);

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAllAccount() {
        List<Account> accountList = accountService.findAllAccount();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        Account acount = accountService.findAcountById(1);
        System.out.println(acount);
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("萨迪哦");
        account.setMoney(10000.0);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = accountService.findAcountById(5);
        account.setName("哦");
        account.setMoney(8000.0);
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccountById() {
        accountService.deleteAccountById(5);
    }
}
