package cn.morooi.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbctemplate", JdbcTemplate.class);
        jdbcTemplate.execute("INSERT INTO account(name, money) VALUES ('ddd', 2000)");
    }
}
