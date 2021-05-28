package com.ecc.exercise.ex3.utils;

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

