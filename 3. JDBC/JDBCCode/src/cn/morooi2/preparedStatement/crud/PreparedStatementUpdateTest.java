package cn.morooi2.preparedStatement.crud;

/*
 * 使用 PreparedStatement 来替换 Statement, 实现对数据表的增删改查操作
 *
 * 增删改(无返回值); 查(有返回值)
 * */

import cn.morooi2.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedStatementUpdateTest {
    @Test
    public void commonUpdateTest() {
//        String sql = "DELETE from customers WHERE id=?";
//        commonUpdate(sql, 20);

        String sql2 = "UPDATE `order` SET order_name=? WHERE order_id=?";
        commonUpdate(sql2, "abc", "2");
    }

    // 通用的增删改操作
    public void commonUpdate(String sql, Object... args) { // sql 中占位符的个数与可变形参长度相同
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 预编译 SQL 语句, 返回 PreparedStatement 实例
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }
    }

    // 修改 customers 表中一条记录
    @Test
    public void updateTest() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 预编译 SQL 语句, 返回 PreparedStatement 实例
            String sql = "UPDATE customers SET name=?, email=?, birth=? WHERE id=?";
            ps = conn.prepareStatement(sql);

            // 填充占位符
            ps.setString(1, "Lax");
            ps.setString(2, "Lax@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ps.setDate(3, new Date(sdf.parse("2020-02-02").getTime()));
            ps.setInt(4, 20);

            // 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭
            JDBCUtils.closeResources(conn, ps);
        }
    }


    // 向 customers 表中添加一条记录
    @Test
    public void insertTest() {
        java.sql.Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 读取配置文件中的 4 个基本信息
            InputStream conf = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            assert conf != null;
            properties.load(conf);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
            // 加载驱动
            Class.forName(driverClass);
            // 获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 预编译 SQL 语句, 返回 PreparedStatement 的实例
            String sql = "INSERT INTO customers (name, email, birth) VALUES (?,?,?)";  // ? -> 占位符
            ps = conn.prepareStatement(sql);

            // 填充占位符
            ps.setString(1, "张伟");
            ps.setString(2, "zhangwei@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ps.setDate(3, new Date(sdf.parse("2020-01-01").getTime()));

            // 执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
