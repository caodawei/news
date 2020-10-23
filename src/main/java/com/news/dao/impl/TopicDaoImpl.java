package com.news.dao.impl;

import com.news.dao.BaseDao;
import com.news.dao.TopicDao;
import com.news.entity.Topic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {
    public TopicDaoImpl(Connection con) {
        super(con);
    }

    private List<Topic> createObj(ResultSet rs) {
        List<Topic> objs = new ArrayList<>();
        try {
            while (rs.next()) {
                Topic obj = new Topic();
                obj.setTid(rs.getInt("tid"));
                obj.setTname(rs.getString("tname"));
                objs.add(obj);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return objs;
    }

    @Override
    public List<Topic> getAll() throws SQLException {
        String sql = "select * from topic";
        Object[] params = null;
        ResultSet rs = executeQuery(sql, params);
        List<Topic> objs = createObj(rs);
        return objs;
    }

    @Override
    public Topic getSingle(int pk) throws SQLException {
        String sql = "select * from topic where tid=?";
        Object[] params = {
                pk
        };
        ResultSet rs = executeQuery(sql, params);
        List<Topic> objs = createObj(rs);
        return objs.size() > 0 ? objs.get(0) : null;
    }

    @Override
    public int insert(Topic obj) throws SQLException {
        int count = 0;
        String sql = "insert into topic (tname) values(?)";
        Object[] params = {
                obj.getTname()
        };
        count = executeUpdate(sql, params);
        return count;
    }

    @Override
    public int update(Topic obj) throws SQLException {
        int count = 0;
        String sql = "update topic set tname=? where tid=?";
        Object[] params = {
                obj.getTname(),
                obj.getTid()
        };
        count = executeUpdate(sql, params);
        return count;
    }

    @Override
    public int delete(Topic obj) throws SQLException {
        int count = 0;
        String sql = "delete from topic where tid=?";
        Object[] params = {
                obj.getTid()
        };
        count = executeUpdate(sql, params);
        return count;
    }
}
