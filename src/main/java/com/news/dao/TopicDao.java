package com.news.dao;

import com.news.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicDao {
    public List<Topic> getAll()throws SQLException;
    public Topic getSingle(int pk)throws SQLException;
    public int insert(Topic obj) throws SQLException;
    public int update(Topic obj)throws SQLException;
    public int delete(Topic obj)throws SQLException;
}
