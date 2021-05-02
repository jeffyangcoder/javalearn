package com.ecc.javalanguage.dbconnect.dao;

import com.ecc.javalanguage.dbconnect.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author yangshiwei
 * @Description 封装了针对于数据表的通用操作
 *              DAO database access object
 * @date 2021/5/2-22:22
 */
public abstract class DAO {
    //    增删改
    public int update(Connection conn, String sql, Object... agrs) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < agrs.length; i++) {
                ps.setObject(i + 1, agrs[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }

    //    查询返回一条记录
    public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
//        获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData metaData = rs.getMetaData();
//        通过获取ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
//                利用反射找到要返回的类型
                T t = clazz.getDeclaredConstructor().newInstance();
                //            处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    //                获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //                获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    //               给T对象指定的columnName属性，复制为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }
        return null;
    }

//    多条记录构成的集合
    public <T> List<T> getForList(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> tList = new ArrayList<T>();
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
//        获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData metaData = rs.getMetaData();
//        通过获取ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
//                利用反射找到要返回的类型
                T t = clazz.getDeclaredConstructor().newInstance();
                //            处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    //                获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //                获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    //               给T对象指定的columnName属性，复制为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                tList.add(t);
            }
            return tList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps,rs);
        }
        return null;
    }

//     用于查询特殊值的通用方法
    public <E>E getValue(Connection conn,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }
            rs = ps.executeQuery();

            if (rs.next()){
                return (E)rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }
        return null;
    }
}
