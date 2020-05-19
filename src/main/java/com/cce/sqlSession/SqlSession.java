package com.cce.sqlSession;


public interface SqlSession {
    <T> T  getMapper(Class<T> DaoInterfaceClass);

    void close();
}
