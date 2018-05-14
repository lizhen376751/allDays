package com.dudu.lizhen.excel;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Test03 {
    //TODO 需要将url\用户名\密码修改为自己的
    public final static String url = "jdbc:mysql://127.0.0.1:3306/test";
    public final static String user = "root";
    public final static String password = "admin";
    public final static String database = "test";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 连接数据库
            Connection con = (Connection) DriverManager.getConnection(url, user, password);
            DatabaseMetaData dbmt = con.getMetaData();
            // 拿到所有的blog数据库中所有信息
            ResultSet rs = dbmt.getTables(database, database, null, new String[]{"TABLE", "VIEW"});
            List<String> tablenames = new ArrayList<String>();
            while (rs.next()) {
                //获取到表的名字
                String tablename = rs.getString("TABLE_NAME");
                tablenames.add(tablename);
            }
            for (String tablename : tablenames) {
                System.out.println(tablename + "表：");
                String sql = "select * from " + tablename;
                Statement st = (Statement) con.createStatement();
                ResultSet dataRs = st.executeQuery(sql);
                ResultSetMetaData rsmt = dataRs.getMetaData();
                // 拿到列数
                int colnums = rsmt.getColumnCount();
                for (int i = 1; i <= colnums; i++) {
                    // 拿到表头信息
                    String colName = rsmt.getColumnName(i);
                    System.out.print(colName + "\t");
                }
                System.out.println();

                while (dataRs.next()) {
                    for (int i = 1; i <= colnums; i++) {
                        // 拿到表信息
                        System.out.print(dataRs.getString(i) + "\t");
                    }
                    System.out.println();
                }

            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
