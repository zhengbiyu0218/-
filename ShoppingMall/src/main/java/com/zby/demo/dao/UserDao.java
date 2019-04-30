package com.zby.demo.dao;

import com.zby.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User findUserByName(String name);
    public int addUser(String name, String pass);
}
