package com.ecc.javalanguage.dbconnect.preparedstatement.crud;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Man;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yangshiwei
 * @Description 使用PreparedStatement实现针对于不同表的通用的查询操作
 * @date 2021/4/28-18:39
 */
public class QueryTest {
    public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> tList= new ArrayList<T>();
        try {
            conn = JDBCUtils.getConnection();

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
            JDBCUtils.closeResource(conn, ps);
        }
        return null;
    }

    public <T> T getInstance(Class <T> clazz,String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

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
            JDBCUtils.closeResource(conn, ps);
        }
        return null;

    }
}
