package com.ecc.javalanguage.dbconnect.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description 操作数据库的工具类
 * @author yangshiwei
 *
 *
 */
public class JDBCUtils {
    /**
     * @return conn
     * @throws Exception
     * @Description 获取数据库连接
     */
    public static Connection getConnection() throws Exception {
        //        1.读取配置文件中的四个基本信息,配置文件在资源文件夹里

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

//        2.加载驱动
        Class.forName(driverClass);

//        3.获取连接
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * @param conn
     * @param ps
     * @Description 关闭数据库连接和Statement操作
     */
    public static void closeResource(Connection conn, Statement ps,ResultSet rs) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

