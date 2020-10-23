package com.news.dao;

import java.sql.*;

public class BaseDao {
    protected Connection con;
    public BaseDao(Connection con){
        this.con=con;
    }

    /**
     *
     * @param sql 要执行的增删改语句
     * @param params 参数数组
     * @return 所影响的行数
     * @throws SQLException
     */
    public int executeUpdate(String sql,Object[] params) throws SQLException {
        PreparedStatement stat=con.prepareStatement(sql);
        if(params!=null){
            for(int i=0;i<params.length;i++){
                stat.setObject(i+1,params[i]);
            }
        }
        int count=stat.executeUpdate();
        return count;
    }

    /**
     *
     * @param sql 要执行的查询语句
     * @param params 参数数组
     * @return 存放查询结果的数据集
     * @throws SQLException
     */
    public ResultSet executeQuery(String sql,Object[] params) throws SQLException {
        PreparedStatement stat=con.prepareStatement(sql);
        if(params!=null){
            for(int i=0;i<params.length;i++){
                stat.setObject(i+1,params[i]);
            }
        }
        ResultSet rs=stat.executeQuery();
        return rs;
    }

    /**
     * 关闭数据库相关对象
     * @param con 连接对象
     * @param stat 语句对象
     * @param rs 数据集对象
     */
    public void closeAll(Connection con, Statement stat,ResultSet rs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
