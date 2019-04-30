package com.zby.demo.service;

import com.zby.demo.model.User;

public interface UserService {
    public User checkName(String name);
    public User checkNameAndPass(String name, String pass);
    public boolean addUser(String name, String pass);
}
