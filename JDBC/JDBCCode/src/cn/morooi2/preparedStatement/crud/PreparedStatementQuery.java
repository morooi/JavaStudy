package cn.morooi2.preparedStatement.crud;

/*
 * 使用 PreparedStatement 实现针对不同表的通用的查询操作
 * */

import cn.morooi2.bean.Customer;
import cn.morooi2.bean.Order;
import cn.morooi2.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementQuery {
    public static void main(String[] args) {
//        String sql = "SELECT id, name, email FROM customers WHERE id=?";
//        Customer customer = getInstance(Customer.class, sql, 1);
//        System.out.println(customer);
//
//        String sql2 = "SELECT order_id orderId, order_name orderName, order_date orderDate FROM `order` WHERE order_id=?";
//        Order order = getInstance(Order.class, sql2, 1);
//        System.out.println(order);

        String sql = "SELECT id, name, email FROM customers WHERE id<?";
        List<Customer> customerList = getForList(Customer.class, sql, 10);
        assert customerList != null;
        customerList.forEach(System.out::println);

        System.out.println("-------");

        String sql2 = "SELECT order_id orderId, order_name orderName, order_date orderDate FROM `order` WHERE order_id<?";
        List<Order> orderList = getForList(Order.class, sql2, 5);
        assert orderList != null;
        orderList.forEach(System.out::println);

    }

    public static <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.closeResources(conn, ps, resultSet);
        }
        return null;
    }


    /*
     * 针对不同的表的通用的查询操作, 返回表中的一条记录
     * */
    public static <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.closeResources(conn, ps, resultSet);
        }

        return null;
    }
}
