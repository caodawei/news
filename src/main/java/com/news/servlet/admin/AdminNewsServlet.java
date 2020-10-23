package com.news.servlet.admin;

import com.news.entity.News;
import com.news.service.NewsService;
import com.news.service.impl.NewsServiceImpl;
import com.news.util.Pager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                list(request, response);
                break;
            case "add":
                response.sendRedirect("/newspages/news_add.jsp");
                break;
            case "edit":
                edit(request,response);
                break;
            case "del":
                del(request,response);
                break;
            case "save":
                try {
                    save(request,response);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nid=Integer.parseInt(request.getParameter("nid"));
        NewsService newsService =new NewsServiceImpl();
        News news=newsService.getSingle(nid);
        request.setAttribute("news",news);
        request.getRequestDispatcher("/newspages/news_add.jsp").forward(request,response);
    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nid=Integer.parseInt(request.getParameter("nid"));
        NewsService newsService =new NewsServiceImpl();
        News news=new News();
        news.setNid(nid);
        int count=newsService.delete(news);
        String msg=count>0?"删除新闻成功！":"删除新闻失败";
        request.getRequestDispatcher("/admin/news?action=list").forward(request,response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, FileUploadException {
        News news=new News();
        NewsService newsService=new NewsServiceImpl();
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        if(ServletFileUpload.isMultipartContent(request)){
            List<FileItem>  fileItems=upload.parseRequest(request);
            for(FileItem item : fileItems){
                //是不是普通表单元素提交过来
                if(item.isFormField()){
                    String name=item.getFieldName();
                    String value="";
                    switch(name){
                        case "nid":
                          value=item.getString();
                          if(!value.equals("")){
                              news.setNid(Integer.parseInt(value));
                          }
                          break;
                        case "ntid":
                            news.setNtid(Integer.parseInt(item.getString()));
                            break;
                        case "ntitle":
                            news.setNtitle(item.getString("utf-8"));
                            break;
                        case "nauthor":
                            news.setNauthor(item.getString("utf-8"));
                            break;
                        case "ncontent":
                            news.setNcontent(item.getString("utf-8"));
                            break;
                        case "nsummary":
                            news.setNsummary(item.getString("utf-8"));
                            break;
                    }

                }else{//文件
                    String path=request.getSession().getServletContext().getRealPath("/upload");
                    //如果文件夹不存在则创建一个
                    File dir=new File(path);
                    if(!dir.exists()){
                        dir.mkdir();
                    }
                    //获得上传文件的扩展名
                    String ext= FilenameUtils.getExtension(item.getName());
                    long time=new Date().getTime();
                    String filename="upload"+time+"."+ext;
                    try {
                        item.write(new File(path,filename));
                        news.setNpicPath(filename);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        }

        int count=0;
        if(news.getNid()==null){
            news.setNcreateDate(new Date() );
            count=newsService.insert(news);
        }else{
            news.setNmodifyDate(new Date());
            count=newsService.update(news);
        }
        if(count>0){
            response.sendRedirect("/admin/news");
        }else{
            request.setAttribute("error","保存新闻失败");
            request.getRequestDispatcher("/admin/news").forward(request,response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int pageSize = 10;

        List<News> newsList = new ArrayList<>();
        NewsService newsService = new NewsServiceImpl();
        int count = 0;


        count = newsService.count();
        newsList = newsService.getAll(page, pageSize);


        Pager pager = new Pager(page, pageSize, count);
        request.setAttribute("newsList", newsList);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("/newspages/admin.jsp").forward(request,response);
    }
}
