package com.ecc.exercise.ex3.utils;

import java.sql.*;

/**
 * @ClassName MysqlDbConn
 * @Description 获取mysql数据库的链接
 * @Author jzg
 * @Date 2021/3/15
 * Version
 */

public class MySQLDBConnect {
    static Connection conn = null;
    private static final String url = "jdbc:mysql://localhost:3306/javaera?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "1314cx";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connected false!");
        }
    }

    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    //遍历role表
    public static void roleRead() {
        Statement stmt = null;
        String sql = "SELECT * FROM role";
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String roleName = rs.getString("roleName");
                String dataType = rs.getString("dataType");
                String roleDes = rs.getString("roleDes");

                System.out.print("ID: " + id);
                System.out.print(",roleName: " + roleName);
                System.out.print(",dataType: " + dataType);
                System.out.print(",roleDes: " + roleDes + "\n");
            }
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
