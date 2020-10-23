package com.news.dao;

import com.news.entity.Comment;

import java.sql.SQLException;
import java.util.List;

public interface CommentDao {
    public List<Comment> getAll()throws SQLException;
    public Comment getSingle(int pk)throws SQLException;
    public int insert(Comment obj)throws SQLException;
    public int update(Comment obj)throws SQLException;
    public int delete(Comment obj)throws SQLException;

    List<Comment> getByNews(int nid)throws SQLException;
}
