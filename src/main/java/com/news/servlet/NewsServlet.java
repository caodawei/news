package com.news.servlet;

import com.news.entity.Comment;
import com.news.entity.News;
import com.news.service.CommentService;
import com.news.service.NewsService;
import com.news.service.impl.CommentServiceImpl;
import com.news.service.impl.NewsServiceImpl;
import com.news.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = action == null ? "list" : action;
        switch (action) {
            case "detail":
                detail(request,response);
            case "add":
                break;
            case "edit":
                break;
            case "del":
                break;
            case "list":
                list(request,response);
                break;
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nid=Integer.parseInt(request.getParameter("nid"));
        NewsService newsService=new NewsServiceImpl();
        News news=newsService.getSingle(nid);
        CommentService commentService =new CommentServiceImpl();
        List<Comment> comments=commentService.getByNews(nid);
        request.setAttribute("news",news);
        request.setAttribute("comments",comments);
        request.getRequestDispatcher("/newspages/news_read.jsp").forward(request,response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TopicService topicService =new TopicServiceImpl();
//        List<Topic> topics=topicService.getAll();
//        request.setAttribute("topics",topics);
        int page=1;
        if(request.getParameter("page")!=null){
            page=Integer.parseInt(request.getParameter("page"));
        }
        int pageSize=3;
        int tid=0;
        if(request.getParameter("tid")!=null){
            tid=Integer.parseInt(request.getParameter("tid"));
        }
        List<News> newsList=new ArrayList<>();
        NewsService newsService =new NewsServiceImpl();
        int count=0;

        if(tid==0){
            count=newsService.count();
            newsList=newsService.getAll(page,pageSize);
        }else{
            count=newsService.count(tid);
            newsList=newsService.getByTopic(tid,page,pageSize);
        }
        String queryString=tid==0?"":"&tid="+tid;
        Pager pager=new Pager(page,pageSize,count);
        request.setAttribute("newsList",newsList);
        request.setAttribute("pager",pager);
        request.setAttribute("qs",queryString);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
