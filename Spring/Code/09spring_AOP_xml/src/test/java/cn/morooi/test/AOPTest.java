package cn.morooi.test;

import cn.morooi.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService)applicationContext.getBean("accountService");
        accountService.saveAccount();
//        accountService.updateAccount(10);
//        int i = accountService.deleteAccount();
    }
}
