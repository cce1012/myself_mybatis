package com.cce.sqlSession;

import com.cce.cfg.Configuration;
import com.cce.defaults.DefaultSqlSessionFactory;
import com.cce.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
