package com.news.service;

import com.news.entity.News;
import com.news.entity.Topic;

import java.util.List;

public interface NewsService {
    int count();
    int count(int tid);
    public List<News> getAll();
    List<News> getAll(int page,int pageSize);
    List<News> getByTopic(int tid);
    List<News> getByTopic(int tid,int page,int pageSize);
    public News getSingle(int pk);
    public int insert(News obj);
    public int update(News obj);
    public int delete(News obj);
}
