package cn.morooi1.connection;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {
    // 方式一:
    @Test
    public void testConnection1() throws SQLException {
        // 获取 Driver 的实现类对象
        Driver driver = new com.mysql.cj.jdbc.Driver();
        // 提供要连接的数据库
        String url = "jdbc:mysql://10.211.55.6:3306/test";
        Properties info = new Properties();
        // 将用户名和密码封装在 Properties 中
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        java.sql.Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    // 方式二: 对方式一的迭代
    @Test
    public void testConnection2() throws Exception {
        // 获取 Driver 的实现类对象, 使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        // 提供要连接的数据库
        String url = "jdbc:mysql://10.211.55.6:3306/test";
        Properties info = new Properties();
        // 将用户名和密码封装在 Properties 中
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        java.sql.Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    // 方式三: 使用 DriverManager 替换 Driver
    @Test
    public void testConnection3() throws Exception {
        // 获取 Drive 的实现类对象, 使用反射
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 提供另外三个连接的基本信息
        String url = "jdbc:mysql://10.211.55.6/test";
        String user = "root";
        String password = "123456";

        // 注册驱动
        DriverManager.registerDriver(driver);
        // 获取连接
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    // 方式四:
    @Test
    public void testConnection4() throws Exception {
        // 提供三个连接的基本信息
        String url = "jdbc:mysql://10.211.55.6/test";
        String user = "root";
        String password = "123456";

        // 加载 Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取连接
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /*
     * 方式五 (final): 将数据库连接需要的四个基本信息声明在配置文件中, 通过读取配置文件的方式, 获取连接
     * 好处:
     *  1. 实现了数据与代码的分离, 实现了解耦
     *  2. 如果需要修改配置文件信息, 可以避免程序重新打包
     * */
    @Test
    public void getConnection5() throws Exception {
        // 读取配置文件中的 4 个基本信息
        InputStream conf = Connection.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        assert conf != null;
        properties.load(conf);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        Class.forName(driverClass);

        java.sql.Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
