package com.ecc.javalanguage.dbconnect.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author yangshiwei
 * @Description 操作数据库的工具类
 */
public class JDBCUtils {
    /**
     * @return conn
     * @throws Exception
     * @Description 获取数据库连接
     */
    public static Connection getConnection01() throws Exception {
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
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeResource1(Connection conn, Statement ps) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //    使用Druid数据库连接池技术
    private static DataSource source;

    static {
        Properties pros = null;
        try {
            pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");


            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        try {
            return source.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /*
     * @Description 使用dbutils.jar中提供的Dbutils工具类，实现资源关闭
     * @author yangshiwei
     * @date 2021/5/5 13:49
 * @param conn
 * @param ps
     */
    public static void closeResource(Connection conn, Statement ps,ResultSet rs) {
        try {
            DbUtils.close(conn);
            DbUtils.close(ps);
            DbUtils.close(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeResource(Connection conn, Statement ps) {
//        try {
//            DbUtils.close(conn);
//            DbUtils.close(ps);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
    }
}

