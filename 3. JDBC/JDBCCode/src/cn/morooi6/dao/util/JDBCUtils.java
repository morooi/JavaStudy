package cn.morooi6.dao.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

//    // 获取数据库的连接
//    public static Connection getConnection() throws Exception {
//        InputStream conf = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties properties = new Properties();
//        assert conf != null;
//        properties.load(conf);
//
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        String url = properties.getProperty("url");
//        String driverClass = properties.getProperty("driverClass");
//        // 加载驱动
//        Class.forName(driverClass);
//        // 获取连接
//        return DriverManager.getConnection(url, user, password);
//    }

    // 使用 Druid 数据库连接池
    private static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream conf = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            assert conf != null;
            properties.load(conf);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(resultSet);
    }
}
