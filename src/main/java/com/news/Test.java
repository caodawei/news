package com.news;


import com.news.entity.Comment;
import com.news.entity.News;
import com.news.entity.Topic;
import com.news.entity.User;
import com.news.service.CommentService;
import com.news.service.NewsService;
import com.news.service.TopicService;
import com.news.service.UserService;
import com.news.service.impl.CommentServiceImpl;
import com.news.service.impl.NewsServiceImpl;
import com.news.service.impl.TopicServiceImpl;
import com.news.service.impl.UserServiceImpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        NewsService service=new NewsServiceImpl();
        List<News> objs=service.getAll();
        for(News obj : objs){
            System.out.println(obj.getNtitle()+","+obj.getNsummary());
        }
    }



}
