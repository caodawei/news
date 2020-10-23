package com.news.dao.impl;

import com.news.dao.BaseDao;
import com.news.dao.NewsDao;
import com.news.entity.News;
import com.news.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    public NewsDaoImpl(Connection con){
        super(con);
    }
    private  List<News> createObj(ResultSet rs){
        List<News> objs=new ArrayList<>();
        try {
            while(rs.next()){
                News obj=new News();
                obj.setNid(rs.getInt("nid"));
                obj.setNtid(rs.getInt("ntid"));
                obj.setNtitle(rs.getString("ntitle"));
                obj.setNauthor(rs.getString("nauthor"));
                obj.setNpicPath(rs.getString("npicPath"));
                obj.setNcontent(rs.getString("ncontent"));
                obj.setNsummary(rs.getString("nsummary"));
                obj.setNcreateDate(rs.getTimestamp("ncreateDate"));
                obj.setNmodifyDate(rs.getTimestamp("nmodifyDate"));
                obj.setTopic(new TopicDaoImpl(con).getSingle(rs.getInt("ntid")));
                objs.add(obj);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return objs;
    }

    @Override
    public List<News> getAll() throws SQLException {
        String sql="select * from news order by ncreateDate desc";
        Object[] params=null;
        ResultSet rs=executeQuery(sql,params);
        List<News> objs=createObj(rs);
        return objs;
    }

    @Override
    public List<News> getByTopic(int tid) throws SQLException {
        String sql="select * from news where ntid=? order by ncreateDate desc";
        Object[] params= {
                tid
        };
        ResultSet rs=executeQuery(sql,params);
        List<News> objs=createObj(rs);
        return objs;
    }

    @Override
    public int count() throws SQLException {
        int count=0;
        String sql="select count(1) from news";
        Object[] params= null;
        ResultSet rs=executeQuery(sql,params);
        if(rs.next()){
            count=rs.getInt(1);
        }
        return count;
    }

    @Override
    public List<News> getAll(int page, int pageSize) throws SQLException {
        String sql="select * from news order by ncreateDate desc limit ?,?";
        Object[] params= {
                (page-1)*pageSize,
                pageSize
        };
        ResultSet rs=executeQuery(sql,params);
        List<News> objs=createObj(rs);
        return objs;
    }

    @Override
    public List<News> getByTopic(int tid, int page, int pageSize) throws SQLException {
        String sql="select * from news where ntid=? order by ncreateDate desc limit ?,?";
        Object[] params= {
                tid,
                (page-1)*pageSize,
                pageSize
        };
        ResultSet rs=executeQuery(sql,params);
        List<News> objs=createObj(rs);
        return objs;
    }

    @Override
    public int count(int tid) throws SQLException {
        int count=0;
        String sql="select count(1) from news where ntid=?";
        Object[] params= {
                tid
        };
        ResultSet rs=executeQuery(sql,params);
        if(rs.next()){
            count=rs.getInt(1);
        }
        return count;
    }

    @Override
    public News getSingle(int pk) throws SQLException {
        String sql="select * from news where nid=?";
        Object[] params= {
                pk
        };
        ResultSet rs=executeQuery(sql,params);
        List<News> objs=createObj(rs);
        return objs.size()>0?objs.get(0):null;
    }

    @Override
    public int insert(News obj) throws SQLException {
        int count=0;
        String sql="insert into news (ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nsummary)" +
                "values (?,?,?,?,?,?,?)";
        Object[] params={
                obj.getNtid(),
                obj.getNtitle(),
                obj.getNauthor(),
                new Date(),
                obj.getNpicPath(),
                obj.getNcontent(),
                obj.getNsummary()
        };
        count=executeUpdate(sql,params);
        return count;
    }

    @Override
    public int update(News obj) throws SQLException {
        int count=0;
        String sql="update news set ntid=?,ntitle=?,nauthor=?,npicPath=?,ncontent=?,nmodifyDate=?,nsummary=? where nid=?" ;
        Object[] params={
                obj.getNtid(),
                obj.getNtitle(),
                obj.getNauthor(),
                obj.getNpicPath(),
                obj.getNcontent(),
                new Date(),
                obj.getNsummary(),
                obj.getNid()
        };
        count=executeUpdate(sql,params);
        return count;
    }

    @Override
    public int delete(News obj) throws SQLException {
        int count=0;
        String sql="delete from  news where nid=?" ;
        Object[] params={

                obj.getNid()
        };
        count=executeUpdate(sql,params);
        return count;
    }
}
