package com.cce.defaults;

import com.cce.cfg.Configuration;
import com.cce.sqlSession.SqlSession;
import com.cce.sqlSession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg=cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
