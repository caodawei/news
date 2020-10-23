package com.news.service.impl;

import com.news.dao.CommentDao;
import com.news.dao.UserDao;
import com.news.dao.impl.CommentDaoImpl;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.User;
import com.news.service.UserService;
import com.news.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll() {
        Connection con= DatabaseUtil.getConnection();
        UserDao dao=new UserDaoImpl(con);
        List<User> objs=new ArrayList<>();
        try {
            objs=dao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return objs;
    }

    @Override
    public User Login(String uname, String upwd) {
        Connection con= DatabaseUtil.getConnection();
        UserDao dao=new UserDaoImpl(con);
        User obj=null;
        try {
            obj=dao.getByUname(uname);
            if(obj!=null){
                if(!obj.getUpwd().equals(upwd)){
                    obj=null;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return obj;
    }

    @Override
    public User getSingle(int pk) {
        Connection con= DatabaseUtil.getConnection();
        UserDao dao=new UserDaoImpl(con);
        User obj=null;
        try {
            obj=dao.getSingle(pk);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return obj;
    }

    @Override
    public int insert(User obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        UserDao dao=new UserDaoImpl(con);
        try {
            count= dao.insert(obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int update(User obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        UserDao dao=new UserDaoImpl(con);
        try {
            count= dao.update(obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int delete(User obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        UserDao dao=new UserDaoImpl(con);
        try {
            count= dao.delete(obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }
}
