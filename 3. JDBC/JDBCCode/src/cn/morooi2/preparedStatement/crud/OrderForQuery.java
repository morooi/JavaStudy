package cn.morooi2.preparedStatement.crud;

/*
 * 针对于 Order 表的通用的查询操作
 * */

import cn.morooi2.bean.Order;
import cn.morooi2.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class OrderForQuery {

    /*
     * 针对表的字段名与类的属性名不相同的情况
     *   1. 必须声明 SQL 时, 使用类的属性名来命名字段的别名
     *   2. 使用 ResultSetMetaData 时, 需要使用 getColumnLabel() 来替换 getColunmName() 获取列的别名
     *       说明: 如果 sql 中没有给字段起别名, getColumnLabel() 获取的就是列名
     * */
    public static void main(String[] args) {
        String sql = "SELECT order_id orderId, order_name orderName, order_date orderDate FROM `order` WHERE order_id=?";
        Order order = queryForOrder(sql, 1);
        System.out.println(order);
    }

    public static Order queryForOrder(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    // 获取每个列的列值: 通过 ResultSet
                    Object columnValue = rs.getObject(i + 1);
                    // 通过 ResultSetMetaDate
                    // 获取列的列名: getColumnName() -> 不用
                    // 获取列的别名: getColumnLabel() -> 推荐使用
                    String columnName = rsmd.getColumnLabel(i + 1);
                    // 通过反射, 将对象指定名 columnName 的属性赋值为指定的值 columnValue
                    Field field = Order.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps, rs);
        }

        return null;
    }
}
