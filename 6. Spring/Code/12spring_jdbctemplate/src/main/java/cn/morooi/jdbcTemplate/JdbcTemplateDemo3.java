package cn.morooi.jdbcTemplate;

import cn.morooi.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate 的 CRUD
 */

public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbctemplate", JdbcTemplate.class);

//        // 保存
//        jdbcTemplate.update("INSERT INTO account(name, money) VALUES (?, ?)", "eee", 3333);
//        // 更新
//        jdbcTemplate.update("UPDATE account SET name = ?, money = ? WHERE id = ?", "你说啥", 10000, 7);
//        // 删除
//        jdbcTemplate.update("DELETE account WHERE id = ?", 8);
//        // 查询所有
//        List<Account> accountList = jdbcTemplate.query("SELECT * FROM account where money > ?", new AccountRowMapper(), 1000f);
//        List<Account> accountList = jdbcTemplate.query("SELECT * FROM account where money > ?",
//                new BeanPropertyRowMapper<>(Account.class), 1000f);
//        for (Account account : accountList) {
//            System.out.println(account);
//        }
//        // 查询一个
//        List<Account> accounts = jdbcTemplate.query("SELECT * FROM account where id = ?",
//                new BeanPropertyRowMapper<>(Account.class), 1);
//        System.out.println(accounts.isEmpty() ? "没有结果" : accounts.get(0));

        // 查询返回一行一列(使用聚合函数, 但不加 group by 子句)
        Integer cout = jdbcTemplate.queryForObject("SELECT count(*) FROM account WHERE money > ?", Integer.class, 1000f);
        System.out.println(cout);
    }
}

/**
 * 定义 Account 的封装策略
 */
class AccountRowMapper implements RowMapper<Account> {

    /**
     * 把结果集中的数据封装到 Account 中, 然后由 Spring 把每个 Account 加到集合中
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}