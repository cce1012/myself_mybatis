package com.cce.defaults;

import com.cce.cfg.Configuration;
import com.cce.proxy.MapperProxy;
import com.cce.sqlSession.SqlSession;
import com.cce.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg=cfg;
        conn=DataSourceUtil.getConnection(cfg);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
       return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));
    }

    public void close() {
        if (conn!=null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
