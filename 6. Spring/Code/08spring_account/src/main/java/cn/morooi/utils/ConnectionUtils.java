package cn.morooi.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类, 用于从数据源中获取一个连接, 并且实现和线程的绑定
 */

public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的链接
     *
     * @return
     */
    public Connection getThreadLocalConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    /**
     * 把连接和线程解绑
     */
    public void removeThreadLocalConnection() {
        threadLocal.remove();
    }
}
