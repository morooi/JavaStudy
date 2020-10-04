package cn.morooi.mybatis.utils;

import cn.morooi.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于创建数据源的工具类
 */

public class DataSourceUtil {
    /**
     * 用于获取一个连接
     * @param conf
     * @return
     */
    public static Connection getConnection(Configuration conf) {
        Connection conn = null;
        try {
            Class.forName(conf.getDriver());
            conn = DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
