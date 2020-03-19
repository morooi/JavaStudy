package cn.morooi7.dbutils;

import cn.morooi6.dao.bean.Customer;
import cn.morooi6.dao.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerTest {
    // 测试插入
    @Test
    public void insert() {
        Connection conn = null;
        try {
            QueryRunner queryRunner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO customers (name, email, birth) VALUES (?, ?, ?)";
            int insertCount = queryRunner.update(conn, sql, "蔡徐坤", "cxk@gmail.com", "2020-01-01");
            System.out.println("添加了 " + insertCount + " 条记录");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }

    // 测试查询(一条记录)
    // BeanHandler()
    @Test
    public void query() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT id, name, email, birth FROM customers WHERE id = ?";
            BeanHandler<Customer> customerBeanHandler = new BeanHandler<>(Customer.class);
            Customer customer = queryRunner.query(conn, sql, customerBeanHandler, 3);
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }

    // 测试查询(多条记录)
    // BeanListHandler()
    @Test
    public void queryList() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT id, name, email, birth FROM customers WHERE id < ?";
            BeanListHandler<Customer> customerBeanHandler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = queryRunner.query(conn, sql, customerBeanHandler, 10);
            customers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }

    // 测试查询(一条记录)
    // MapHandler()
    @Test
    public void queryMap() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT id, name, email, birth FROM customers WHERE id = ?";
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> query = queryRunner.query(conn, sql, mapHandler, 5);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }

    // 测试查询(多条记录)
    // MapListHandler()
    @Test
    public void queryMapList() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT id, name, email, birth FROM customers WHERE id < ?";
            MapListHandler mapListHandler = new MapListHandler();
            List<Map<String, Object>> mapList = queryRunner.query(conn, sql, mapListHandler, 10);
            mapList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }

    // 测试查询 (特殊值)
    // ScalarHandler()
    @Test
    public void queryScalar() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT count(*) FROM customers";
            ScalarHandler<Long> handler = new ScalarHandler<>();
            Long query = queryRunner.query(conn, sql, handler);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }

    // 测试查询 (特殊值 生日)
    // ScalarHandler()
    @Test
    public void queryScalarDate() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT max(birth) FROM customers";
            ScalarHandler<Date> handler = new ScalarHandler<>();
            Date query = queryRunner.query(conn, sql, handler);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, null);
        }
    }
}
