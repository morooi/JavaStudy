package cn.morooi3.blob;

/*
 * 测试使用 PreparedStatement 操作 Blob 类型的数据
 * */

import cn.morooi2.bean.Customer;
import cn.morooi2.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.sql.*;

public class BlobTest {
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO customers(name, email, birth, photo) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, "胡一菲");
            ps.setString(2, "yifei@gmail.com");
            ps.setString(3, "2000-01-01");
            FileInputStream inputStream = new FileInputStream(
                    new File("/Users/morooi/OneDrive/图片/壁纸/超清/wallhaven-757880.jpg"));
            ps.setBlob(4, inputStream);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }
    }

    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM customers WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "22");

            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                // 方式一
                //            int id = resultSet.getInt(1);
                //            String name = resultSet.getString(2);
                //            String email = resultSet.getString(3);
                //            Date birth = resultSet.getDate(4);

                // 方式二
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");

                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);

                // 将 Blob 类型的字段下载下来, 以文件的方式保存在本地
                Blob photo = resultSet.getBlob("photo");
                inputStream = photo.getBinaryStream();
                outputStream = new FileOutputStream("huyifei.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResources(conn, ps, resultSet);
        }

    }
}

