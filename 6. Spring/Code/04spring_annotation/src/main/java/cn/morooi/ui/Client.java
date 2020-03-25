package cn.morooi.ui;

import cn.morooi.dao.AccountDao;
import cn.morooi.dao.impl.AccountDaoImpl;
import cn.morooi.service.AccountService;
import cn.morooi.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * 获取 spring 的 Ioc 核心容器, 并根据 id 获取对象
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据 id 获取 Bean 对象
        AccountService accountService1 = (AccountService)ac.getBean("accountServiceImpl");
        AccountService accountService2 = (AccountService)ac.getBean("accountServiceImpl");
        System.out.println(accountService1 == accountService2);
//        accountService.saveAccount();
    }
}
