package com.news.dao.impl;

import com.news.dao.BaseDao;
import com.news.dao.CommentDao;
import com.news.entity.Comment;
import com.news.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoImpl extends BaseDao implements CommentDao {
    public CommentDaoImpl(Connection con) {
        super(con);
    }

    private List<Comment> createObj(ResultSet rs) {
        List<Comment> objs = new ArrayList<>();
        try {
            while (rs.next()) {
                Comment obj = new Comment();
                obj.setCid(rs.getInt("cid"));
                obj.setCnid(rs.getInt("cnid"));
                obj.setCcontent(rs.getString("ccontent"));
                obj.setCip(rs.getString("cip"));
                obj.setCauthor(rs.getString("cauthor"));
                obj.setCdate(rs.getTimestamp("cdate"));

                obj.setNews(new NewsDaoImpl(con).getSingle(rs.getInt("cnid")));
                objs.add(obj);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return objs;
    }

    @Override
    public List<Comment> getAll() throws SQLException {
        String sql = "select * from comment";
        Object[] params = null;
        ResultSet rs = executeQuery(sql, params);
        List<Comment> objs = createObj(rs);
        return objs;
    }

    @Override
    public List<Comment> getByNews(int nid) throws SQLException {
        String sql = "select * from comment where cnid=?";
        Object[] params = {
                nid
        };
        ResultSet rs = executeQuery(sql, params);
        List<Comment> objs = createObj(rs);
        return objs;
    }
    @Override
    public Comment getSingle(int pk) throws SQLException {
        String sql = "select * from comment where cid=?";
        Object[] params = {
                pk
        };
        ResultSet rs = executeQuery(sql, params);
        List<Comment> objs = createObj(rs);
        return objs.size() > 0 ? objs.get(0) : null;
    }

    @Override
    public int insert(Comment obj) throws SQLException {
        int count = 0;
        String sql = "insert into comment (cnid,ccontent,cdate,cip,cauthor) values(?,?,?,?,?)";
        Object[] params = {
                obj.getCnid(),
                obj.getCcontent(),
                new Date(),
                obj.getCip(),
                obj.getCauthor()
        };
        count=executeUpdate(sql,params);
        return count;
    }

    @Override
    public int update(Comment obj) throws SQLException {
        int count = 0;
        String sql = "update comment set cnid=?,ccontent=?,cip=?,cauthor=? where cid=?";
        Object[] params = {
                obj.getCnid(),
                obj.getCcontent(),
                obj.getCip(),
                obj.getCauthor(),
                obj.getCid()
        };
        count=executeUpdate(sql,params);
        return count;
    }

    @Override
    public int delete(Comment obj) throws SQLException {
        int count = 0;
        String sql = "delete from  comment where cid=?";
        Object[] params = {
                obj.getCid()
        };
        count=executeUpdate(sql,params);
        return count;
    }

}
