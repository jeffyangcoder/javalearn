package com.ecc.javalanguage.dbconnect.preparedstatement.crud;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Man;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author yangshiwei
 * @Description 针对man表的通用查询操作
 * @date 2021/4/27 18:53
 */

public class manForQuery {
    /**
     * @param sql
     * @param args
     * @Description
     * @author yangshiwei
     * @date 2021/4/27 18:56
     */
    public Man queryForMan(String sql, Object... args) {
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
                Man man = new Man();
                //            处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    //                获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //                获取每个列的列名
//                    String columnName = metaData.getColumnName(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    //               给man对象指定的columnName属性，复制为columnValue，通过反射
                    Field field = Man.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(man, columnValue);
                }
                return man;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
        return null;
    }
}
