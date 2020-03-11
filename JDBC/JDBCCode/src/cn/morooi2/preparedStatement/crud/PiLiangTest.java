package cn.morooi2.preparedStatement.crud;

import cn.morooi2.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PiLiangTest {
    // 第一种批量插入的方法
    @Test
    public void Test01() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO `count` VALUES (?)";
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < 20000; i++) {
                ps.setString(1, "test_" + i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("总时间: " + (end - start) + " ms"); // 10081 ms
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }
    }

    /*
     * 第二种批量插入的方法:
     * 1. addBatch(), executeBatch(), clearBatch()
     * 2. MySQL 服务器默认是关闭批处理的, 我们需要通过一个参数, 让 MySQL 开启批处理的支持
     *      ?rewriteBatchedStatements=true
     * */
    @Test
    public void Test02() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO `count` VALUES (?)";
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < 1000000; i++) {
                ps.setString(1, "test_" + i);
                // 1. "攒" SQl
                ps.addBatch();
                if (i % 500 == 0) {
                    // 2. 执行
                    ps.executeBatch();
                    // 3. 清空
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("总时间: " + (end - start) + " ms"); // 20000: 582 ms, 1000000: 5121 ms
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }
    }

    /*
     * 第三种批量插入的方法: 关闭自动提交 -> 推荐
     * */
    @Test
    public void Test03() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            // 设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "INSERT INTO `count` VALUES (?)";
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < 20000; i++) {
                ps.setString(1, "test_" + i);
                // 1. "攒" SQl
                ps.addBatch();
                if (i % 500 == 0) {
                    // 2. 执行
                    ps.executeBatch();
                    // 3. 清空
                    ps.clearBatch();
                }
            }
            // 提交数据
            conn.commit();

            long end = System.currentTimeMillis();
            System.out.println("总时间: " + (end - start) + " ms"); // 20000: 569 ms, 1000000: 4204 ms
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }
    }
}
