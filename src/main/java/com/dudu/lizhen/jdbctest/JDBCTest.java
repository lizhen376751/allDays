package com.dudu.lizhen.jdbctest;

import java.sql.*;

/**
 * JDBC数据库连接，SQlServer
 * Created by lizhen on 2018/4/2 0002.
 */
public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动
        String URL = "jdbc:sqlserver://192.168.1.112:1433; DatabaseName=ZMTPlatform"; //连接服务器和数据库sampl

//        String URL="jdbc:sqlserver://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="ZMTPlatform";
        String PASSWORD="ZMTPlatform";
        //1.加载驱动程序
        Class.forName(driverName);
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from ZMT_Seller");
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("SellerName"));
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }
}
