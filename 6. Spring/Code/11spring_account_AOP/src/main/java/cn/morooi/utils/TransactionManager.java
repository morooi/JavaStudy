package cn.morooi.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 和事务管理相关的工具类
 *
 * 开启事务, 提交事务, 回滚事务, 释放连接
 */

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
             connectionUtils.getThreadLocalConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction() {
        try {
            connectionUtils.getThreadLocalConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction() {
        try {
            connectionUtils.getThreadLocalConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void releaseTransaction() {
        try {
            connectionUtils.getThreadLocalConnection().close(); // 还回连接池中
            connectionUtils.removeThreadLocalConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
