package com.news.service;

import com.news.entity.Comment;
import com.news.entity.News;

import java.util.List;

public interface CommentService {
    public List<Comment> getAll();
    public List<Comment> getByNews(int nid);
    public Comment getSingle(int pk);
    public int insert(Comment obj);
    public int update(Comment obj);
    public int delete(Comment obj);
}
