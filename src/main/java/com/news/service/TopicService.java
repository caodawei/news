package com.news.service;

import com.news.entity.Topic;

import java.util.List;

public interface TopicService {
    public List<Topic> getAll();
    public Topic getSingle(int pk);
    public int insert(Topic obj);
    public int update(Topic obj);
    public int delete(Topic obj);
}
