package cn.morooi4.transaction;

import cn.morooi2.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class TransactionTest {

    // ============== 未考虑数据库事务的转账操作=================
    /*
     * 针对数据表 user_table 来说:
     *   AA 用户给 BB 用户转账 100
     *   UPDATE user_table SET balance = balance - 100 WHERE user = AA
     *   UPDATE user_table SET balance = balance + 100 WHERE user = BB
     * */
    @Test
    public void testUpdate() {
        String sql1 = "UPDATE user_table SET balance = balance - 100 WHERE user = ?";
        update(sql1, "AA");

        //

        String sql2 = "UPDATE user_table SET balance = balance + 100 WHERE user = ?";
        update(sql2, "BB");
    }

    // 通用的增删改操作 --version 1.0
    public int update(String sql, Object... args) { // sql 中占位符的个数与可变形参长度相同
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
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }
        return 0;
    }

    // ============== 考虑数据库事务的转账操作=================
    @Test
    public void testUpdateWithTransaction() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false); // 取消数据的自动提交

            String sql1 = "UPDATE user_table SET balance = balance - 100 WHERE user = ?";
            update(conn, sql1, "AA");

            // 模拟网络异常
//            System.out.println(10 / 0);

            String sql2 = "UPDATE user_table SET balance = balance + 100 WHERE user = ?";
            update(conn, sql2, "BB");

            conn.commit(); // 提交

            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();

            // 回滚数据
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 修改其为自动提交数据
            // 主要针对使用数据库连接池的使用
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResources(conn, null);
        }
    }

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

    // ==============================================
    @Test
    public void testTransactionSelect() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        // 获取当前连接的隔离级别
        System.out.println(conn.getTransactionIsolation());
         // 设置当前连接的隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        // 取消自动提交数据
        conn.setAutoCommit(false);

        String sql = "SELECT user, password, balance FROM user_table WHERE user = ?";
        User cc = getInstance(User.class, conn, sql, "CC");
        System.out.println(cc);
    }

    @Test
    public void testTransactionUpdate() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        // 取消自动提交数据
        conn.setAutoCommit(false);

        String sql = "UPDATE user_table SET balance = ? WHERE user = ?";
        update(conn, sql, 5000, "CC");
//        System.out.println(cc);
        Thread.sleep(15000);
        System.out.println("修改成功");
    }


    // 通用的查询操作, 用于返回数据表的一条记录 -- version 2.0 (考虑上事务)
    public static <T> T getInstance(Class<T> clazz, Connection conn, String sql, Object... args) {
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
}
