package com.news.service;

import com.news.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public User Login(String uname,String upwd);
    public List<User> getAll();
    public User getSingle(int pk);
    public int insert(User obj);
    public int update(User obj);
    public int delete(User obj);
}
