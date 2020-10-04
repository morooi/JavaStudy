package cn.morooi.ui;

import cn.morooi.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1. 获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据 id 获取 Bean 对象
        AccountService accountService = (AccountService)ac.getBean("accountService");
        System.out.println(accountService);
        accountService.saveUser();

        // 手动关闭容器
        ac.close();
    }
}
