package com.cce.test;

import com.cce.dao.IUserDao;
import com.cce.mybatis.io.Resources;
import com.cce.po.User;
import com.cce.sqlSession.SqlSession;
import com.cce.sqlSession.SqlSessionFactory;
import com.cce.sqlSession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        inputStream.close();

    }
}
