package cn.morooi.factory;

import cn.morooi.service.AccountService;
import cn.morooi.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建 Service 的代理对象的工厂
 */

public class BeanFactory {
    private AccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 获取 Service 的代理对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    transactionManager.beginTransaction();
                    returnValue = method.invoke(accountService, args);
                    transactionManager.commitTransaction();
                } catch (Exception e) {
                    transactionManager.rollbackTransaction();
                    e.printStackTrace();
                } finally {
                    transactionManager.releaseTransaction();
                }
                return returnValue;
            }
        });
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
