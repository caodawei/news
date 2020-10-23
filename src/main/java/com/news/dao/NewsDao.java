package com.news.dao;

import com.news.entity.News;

import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    public List<News> getAll()throws SQLException;
    public News getSingle(int pk)throws SQLException;
    public int insert(News obj)throws SQLException;
    public int update(News obj)throws SQLException;
    public int delete(News obj)throws SQLException;

    public List<News> getByTopic(int tid)throws SQLException;

    int count()throws SQLException;

    List<News> getAll(int page, int pageSize)throws SQLException;

    List<News> getByTopic(int tid, int page, int pageSize)throws SQLException;

    int count(int tid)throws SQLException;
}
