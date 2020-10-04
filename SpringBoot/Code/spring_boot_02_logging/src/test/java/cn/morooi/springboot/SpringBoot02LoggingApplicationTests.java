package cn.morooi.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02LoggingApplicationTests {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        // 日志的级别, 由低到高: trace < debug < info < warn < error
        // 可以调整输出的日志级别, 日志就只会在这个级别以后的高级别生效
        logger.trace("这是 trace 日志");
        logger.debug("这是 debug 日志");
        // Spring Boot 默认使用是 info 级别. 没有指定级别就用 Spring Boot 默认规定的级别: root 级别
        logger.info("这是 info 日志");
        logger.warn("这是 warn 日志");
        logger.error("这是 error 日志");
    }
}
