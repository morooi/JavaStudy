package cn.morooi.mybatis.sqlsession.defaults;

import cn.morooi.mybatis.cfg.Configuration;
import cn.morooi.mybatis.sqlsession.SqlSession;
import cn.morooi.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory 的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
