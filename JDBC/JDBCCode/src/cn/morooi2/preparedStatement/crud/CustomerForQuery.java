package cn.morooi2.preparedStatement.crud;

/*
 * 针对 Customer 表的查询操作
 * */

import cn.morooi2.bean.Customer;
import cn.morooi2.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class CustomerForQuery {
    @Test
    public void testQueryForCustomers() {
        String sql = "SELECT id, name, email, birth FROM customers WHERE id=?";
        Customer customer = queryForCustomers(sql, 1);
        System.out.println(customer);

        String sql1 = "SELECT name, email FROM customers WHERE name=?";
        Customer customer1 = queryForCustomers(sql1, "周杰伦");
        System.out.println(customer1);
    }

    // 通用的查询方法
    public Customer queryForCustomers(String sql, Object... args) {
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
                Customer cust = new Customer();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取每个列的列名
                    String columnName = rsmd.getColumnName(i + 1);
                    // 给 cust 对象指定的 columnName 属性, 赋值为 columnValue: 通过反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cust, columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps, resultSet);
        }

        return null;
    }

    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT id, name, email, birth FROM customers WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 4);

            // 执行, 并返回结果集
            resultSet = ps.executeQuery();
            // 处理结果集
            // next() 判断结果集下一条是否有数据, 如果有数据返回 true, 指针下移; 如果没有返回 false, 指针不动
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                // 方式二:
                // Object[] results = {id, name, email, birth};
                // System.out.println(Arrays.toString(results));

                // 方式三: 将数据封装为一个对象(推荐)
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps, resultSet);
        }

    }
}
