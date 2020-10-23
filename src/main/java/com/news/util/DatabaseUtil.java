package com.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static Properties prop;
    static{
        prop=new Properties();
        InputStream in=DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=prop.getProperty("driver");
        url=prop.getProperty("url");
        user=prop.getProperty("user");
        password=prop.getProperty("password");
    }
    public static Connection getConnection(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con=null;
        try {
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}
