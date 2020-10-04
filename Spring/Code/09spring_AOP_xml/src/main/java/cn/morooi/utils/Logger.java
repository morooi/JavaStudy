package cn.morooi.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的工具类, 提供了公共的代码
 */

public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知 Logger 类中的 beforePrintLog 方法开始记录日志了...");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置通知 Logger 类中的 afterReturningPrintLog 方法开始记录日志了...");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知 Logger 类中的 afterThrowingPrintLog 方法开始记录日志了...");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知 Logger 类中的 afterPrintLog 方法开始记录日志了...");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjd) {
        Object returnValue = null;
        try {
            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...前置");
            Object[] args = pjd.getArgs(); // 得到方法执行所需的参数
            returnValue = pjd.proceed(); // 明确调用业务层方法(切入点方法)
            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...后置");
        } catch (Throwable throwable) {
            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...异常");
            throwable.printStackTrace();
        } finally {
            System.out.println("Logger 类中的 aroundPrintLog 方法开始记录日志了...最终");
        }
        return returnValue;
    }
}
