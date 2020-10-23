package com.news.dao;

import com.news.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> getAll()throws SQLException;
    public User getSingle(int pk)throws SQLException;
    public int insert(User obj)throws SQLException;
    public int update(User obj)throws SQLException;
    public int delete(User obj)throws SQLException;

    public User getByUname(String uname)throws SQLException;
}
