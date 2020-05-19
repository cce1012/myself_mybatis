package com.cce.dao;

import com.cce.annotations.Select;
import com.cce.po.User;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();
}
