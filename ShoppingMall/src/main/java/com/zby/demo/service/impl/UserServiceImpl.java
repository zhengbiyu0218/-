package com.zby.demo.service.impl;

import com.zby.demo.dao.UserDao;
import com.zby.demo.model.User;
import com.zby.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User checkName(String name) {
        User user = userDao.findUserByName(name);
        return user;
    }

    @Override
    public User checkNameAndPass(String name, String pass) {
        User user = userDao.findUserByName(name);
        if (user.getcPassword().equals(pass)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public boolean addUser(String name, String pass) {
        int result = userDao.addUser(name, pass);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

}
