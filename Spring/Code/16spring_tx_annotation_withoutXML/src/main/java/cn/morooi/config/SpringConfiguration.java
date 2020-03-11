package cn.morooi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
@ComponentScan("cn.morooi")
@EnableTransactionManagement
public class SpringConfiguration {
}
