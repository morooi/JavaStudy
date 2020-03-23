package cn.morooi.mybatis.sqlsession.proxy;

import cn.morooi.mybatis.cfg.Mapper;
import cn.morooi.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.IllegalFormatException;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法进行增强, 这里是调用 selectList 方法
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        // 1. 获取方法名
        String methodName = method.getName();
        // 2. 获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        // 3. 组合 key
        String key = className + "." + methodName;
        // 4. 获取 mapper 中的 Mapper 对象
        Mapper mapper = mappers.get(key);
        // 5.
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        return new Executor().selectList(mapper, conn);
    }
}
