package com.news.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.news.entity.User;
import com.news.service.UserService;
import com.news.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        System.out.println("servlet init......");
//    }
//
//    @Override
//    public void destroy() {
//        super.destroy();
//        System.out.println("destory servlet");
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String city=getInitParameter("city");
//        System.out.println("city="+city);
//        String country=getServletContext().getInitParameter("country");
//        System.out.println("country="+country);
//        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "login":
                doLogin(request, response);
                break;
            case "ajaxlogin":
                doAjaxlogin(request, response);
                break;
            case "add":
                break;
            case "edit":
                break;
            case "del":
                break;
            case "":
                break;
        }
    }

    private void doAjaxlogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        UserService userService = new UserServiceImpl();
        User user = userService.Login(uname, upwd);
        HttpSession session = request.getSession();
        String msg = "";
        if (user != null) {
            msg = "ok";
            session.setAttribute("user", user);
        } else {
            msg = "用户名或密码错，请重新登录！";
        }
        writer.print(msg);
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        UserService userService = new UserServiceImpl();
        User user = userService.Login(uname, upwd);
        HttpSession session = request.getSession();
        if (user != null) {
            session.setAttribute("user", user);
        } else {
            request.setAttribute("error", "用户名或密码错，请重新登录！");
        }
        //response.sendRedirect("/news");
        request.getRequestDispatcher("/news?action=list").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
