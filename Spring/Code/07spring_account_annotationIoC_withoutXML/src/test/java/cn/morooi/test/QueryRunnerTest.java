package cn.morooi.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试 QueryRunner 是否单例
 */

public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner1 = applicationContext.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = applicationContext.getBean("runner", QueryRunner.class);
        System.out.println(runner1 == runner2);
    }
}
