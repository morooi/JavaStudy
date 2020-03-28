package cn.morooi.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        // 准备数据源: Spring 的内置数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.211.55.6:3306/spring?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 1. 创建 JdbcTemplate 对象
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        jt.execute("insert into account(name, money) values ('ccc', 1000)");
    }
}
