package com.news.dao.impl;

import com.news.dao.BaseDao;
import com.news.dao.UserDao;
import com.news.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    public UserDaoImpl(Connection con){
        super(con);
    }
    private  List<User> createObj(ResultSet rs){
        List<User> objs=new ArrayList<>();
        try {
            while(rs.next()){
                User obj=new User();
                obj.setUid(rs.getInt("uid"));
                obj.setUname(rs.getString("uname"));
                obj.setUpwd(rs.getString("upwd"));
                objs.add(obj);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return objs;
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql="select * from `user`";
        Object[] params=null;
        ResultSet rs=executeQuery(sql,params);
        List<User> objs=createObj(rs);
        return objs;
    }

    @Override
    public User getByUname(String uname) throws SQLException {
        String sql="select * from `user` where uname=?";
        Object [] params={
                uname
        };
        ResultSet rs=executeQuery(sql,params);
        List<User> objs=createObj(rs);
        return objs.size()>0?objs.get(0):null;
    }

    @Override
    public User getSingle(int pk) throws SQLException {
        String sql="select * from `user` where uid=?";
        Object[] params= {
                pk
        };
        ResultSet rs=executeQuery(sql,params);
        List<User> objs=createObj(rs);
        return objs.size()>0?objs.get(0):null;
    }

    @Override
    public int insert(User obj) throws SQLException {
        int count=0;
        String sql="insert into `user` (uname,upwd)values(?,?)";
        Object[] params={
                obj.getUname(),
                obj.getUpwd()
        };
        count=executeUpdate(sql,params);
        return count;
    }

    @Override
    public int update(User obj) throws SQLException {
        int count=0;
        String sql="update `user` set uname=?,upwd=? where uid=?";
        Object[] params={
                obj.getUname(),
                obj.getUpwd(),
                obj.getUid()
        };
        count=executeUpdate(sql,params);
        return count;
    }

    @Override
    public int delete(User obj) throws SQLException {
        int count=0;
        String sql="delete from `user` where uid=?";
        Object[] params={
                obj.getUid()
        };
        count=executeUpdate(sql,params);
        return count;
    }
}
