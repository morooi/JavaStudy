package cn.morooi.mybatis.sqlsession;

import cn.morooi.mybatis.cfg.Configuration;
import cn.morooi.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import cn.morooi.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个 SqlSessionFactory 对象
 */

public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个 SqlSessionFactory 工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return new DefaultSqlSessionFactory(cfg);
    }
}
