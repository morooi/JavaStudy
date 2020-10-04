package cn.morooi5.dao;

/*
 * 封装了针对数据表的通用操作
 * */


import cn.morooi5.dao.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {

    // 通用的增删改操作 --version 2.0 (考虑到事务)
    public int update(Connection conn, String sql, Object... args) { // sql 中占位符的个数与可变形参长度相同
        PreparedStatement ps = null;
        try {
            // 预编译 SQL 语句, 返回 PreparedStatement 实例
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(null, ps);
        }
        return 0;
    }

    // 通用的查询操作, 用于返回数据表的一条记录 -- version 2.0 (考虑上事务)
    public <T> T getInstance(Class<T> clazz, Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            // 获取结果集的元数据, 获取列数
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if (resultSet.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 给 cust 对象指定的 columnName 属性, 赋值为 columnValue: 通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(null, ps, resultSet);
        }
        return null;
    }

    // 通用的查询操作, 用于返回数据表的多条记录构成的集合 -- version 2.0 (考虑上事务)
    public <T> List<T> getForList(Class<T> clazz, Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            // 获取结果集的元数据, 获取列数
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // 创建集合对象
            ArrayList<T> ts = new ArrayList<>();
            while (resultSet.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 给 cust 对象指定的 columnName 属性, 赋值为 columnValue: 通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                ts.add(t);
            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(null, ps, resultSet);
        }
        return null;
    }

    // 用于查询特殊值的通用方法
    @SuppressWarnings("unchecked")
    public <E> E getValue(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(null, ps, resultSet);
        }
        return null;
    }
}
