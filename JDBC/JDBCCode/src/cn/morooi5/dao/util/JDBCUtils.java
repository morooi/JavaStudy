package cn.morooi5.dao.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    // 获取数据库的连接
    public static Connection getConnection() throws Exception {
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
        return DriverManager.getConnection(url, user, password);
    }

    // 关闭连接和 Statement
    public static void closeResources(Connection conn, Statement ps) {
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

    // 关闭连接, Statement, ResultSet
    public static void closeResources(Connection conn, Statement ps, ResultSet resultSet) {
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
        try {
            if (ps != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
