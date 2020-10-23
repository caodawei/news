package com.news.service.impl;

import com.news.dao.NewsDao;
import com.news.dao.TopicDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.dao.impl.TopicDaoImpl;
import com.news.entity.News;
import com.news.entity.Topic;
import com.news.service.NewsService;
import com.news.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Override
    public int count() {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        try {
            count= dao.count();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int count(int tid) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        try {
            count= dao.count(tid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public List<News> getAll() {
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        List<News> objs=new ArrayList<>();
        try {
            objs=dao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return objs;
    }

    @Override
    public List<News> getAll(int page, int pageSize) {
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        List<News> objs=new ArrayList<>();
        try {
            objs=dao.getAll(page,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return objs;
    }

    @Override
    public List<News> getByTopic(int tid) {
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        List<News> objs=new ArrayList<>();
        try {
            objs=dao.getByTopic(tid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return objs;
    }

    @Override
    public List<News> getByTopic(int tid, int page, int pageSize) {
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        List<News> objs=new ArrayList<>();
        try {
            objs=dao.getByTopic(tid,page,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return objs;
    }

    @Override
    public News getSingle(int pk) {
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        News obj=null;
        try {
            obj=dao.getSingle(pk);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return obj;
    }

    @Override
    public int insert(News obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        try {
            count= dao.insert(obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int update(News obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        try {
            count= dao.update(obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int delete(News obj) {
        int count=0;
        Connection con= DatabaseUtil.getConnection();
        NewsDao dao=new NewsDaoImpl(con);
        try {
            count= dao.delete(obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }
}
