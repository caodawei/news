package com.news.service.impl;

import com.news.dao.CommentDao;
import com.news.dao.impl.CommentDaoImpl;
import com.news.entity.Comment;
import com.news.service.CommentService;
import com.news.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Override
    public List<Comment> getAll() {
        Connection con= DatabaseUtil.getConnection();
        CommentDao dao=new CommentDaoImpl(con);
        List<Comment> objs=new ArrayList<>();
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
    public List<Comment> getByNews(int nid) {
        Connection con= DatabaseUtil.getConnection();
        CommentDao dao=new CommentDaoImpl(con);
        List<Comment> objs=new ArrayList<>();
        try {
            objs=dao.getByNews(nid);

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
    public Comment getSingle(int pk)  {
        Connection con= DatabaseUtil.getConnection();
        CommentDao dao=new CommentDaoImpl(con);
        Comment obj=null;
        try {
            obj= dao.getSingle(pk);
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
    public int insert(Comment obj)  {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        CommentDao dao=new CommentDaoImpl(con);
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
    public int update(Comment obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        CommentDao dao=new CommentDaoImpl(con);
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
    public int delete(Comment obj)  {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        CommentDao dao=new CommentDaoImpl(con);
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
