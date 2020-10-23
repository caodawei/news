package com.news.service.impl;

import com.news.dao.TopicDao;
import com.news.dao.UserDao;
import com.news.dao.impl.TopicDaoImpl;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.Topic;
import com.news.entity.User;
import com.news.service.TopicService;
import com.news.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicServiceImpl implements TopicService {
    @Override
    public List<Topic> getAll() {
        Connection con= DatabaseUtil.getConnection();
        TopicDao dao=new TopicDaoImpl(con);
        List<Topic> objs=new ArrayList<>();
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
    public Topic getSingle(int pk) {
        Connection con= DatabaseUtil.getConnection();
        TopicDao dao=new TopicDaoImpl(con);
        Topic obj=null;
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
    public int insert(Topic obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        TopicDao dao=new TopicDaoImpl(con);
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
    public int update(Topic obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        TopicDao dao=new TopicDaoImpl(con);
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
    public int delete(Topic obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        TopicDao dao=new TopicDaoImpl(con);
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
