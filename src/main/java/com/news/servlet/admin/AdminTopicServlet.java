package com.news.servlet.admin;

import com.alibaba.fastjson.JSON;
import com.news.entity.Topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminTopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action=request.getParameter("action");
       if(action==null){
           action="list";
       }
       switch(action){
           case "list":
               list(request,response);
               break;
           case "add":
               add(request,response);
               break;
           case "edit":
               edit(request,response);
               break;
           case "save":
               save(request,response);
               break;
           case "del":
               del(request,response);
               break;
           case "detail":
               detail(request,response);
               break;
       }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        List<Topic> topics =(List<Topic>)getServletContext().getAttribute("topics");
        //[{"tid":1,"tname":"aaa"},{"tid":2,"tname":"bbb"}]
        StringBuffer msg=new StringBuffer("[");
        for(Topic t:topics){
            msg.append("{\"tid\":").append(t.getTid()).append(",\"tname\":\"")
                    .append(t.getTname()).append("\"},");
        }
        msg.deleteCharAt(msg.length()-1);
        msg.append("]");
        writer.write(msg.toString());

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
    }

    private void del(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }
}
