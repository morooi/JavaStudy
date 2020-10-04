package cn.morooi6.dao;

/*
 * 此接口用于规范针对于 customers 表的常用操作
 * */

import cn.morooi6.dao.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public interface CustomerDAO {

    /**
     * @param conn
     * @param cust
     * @return void
     * @description 将 cust 对象添加到数据库中
     * @author morooi
     * @date 2020/2/21
     */
    void insert(Connection conn, Customer cust);

    /**
     * @param conn
     * @param id
     * @return void
     * @description 针对指定的 id, 删除表中的一条记录
     * @author morooi
     * @date 2020/2/21
     */
    void deleteById(Connection conn, int id);

    /**
     * @param conn
     * @param cust
     * @return void
     * @description 针对内存中的 cust 对象, 去修改数据表中指定的记录
     * @author morooi
     * @date 2020/2/21
     */
    void update(Connection conn, Customer cust);

    /**
     * @param conn
     * @param id
     * @return cn.morooi5.dao.bean.Customer
     * @description 针对指定的 id 查询得到对应的 Customer 对象
     * @author morooi
     * @date 2020/2/21
     */
    Customer getCustomerById(Connection conn, int id);

    /**
     * @param conn
     * @return java.util.List<cn.morooi5.dao.bean.Customer>
     * @description 查询表中的所有记录构成的集合
     * @author morooi
     * @date 2020/2/21
     */
    List<Customer> getAll(Connection conn);

    /**
     * @param conn
     * @return java.lang.Long
     * @description 反回数据表中的数据条目数
     * @author morooi
     * @date 2020/2/21
     */
    Long getCount(Connection conn);

    /**
     * @param conn
     * @return java.sql.Date
     * @description 返回数据表中最大的生日
     * @author morooi
     * @date 2020/2/21
     */
    Date getMaxBirth(Connection conn);
}
