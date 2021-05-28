package com.ecc.exercise.ex3.CRUD;

import com.ecc.javalanguage.dbconnect.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Description 通用的CURD操作
 */
public class CURD {

    public int update(String sql, Object... agrs) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < agrs.length; i++) {
                ps.setObject(i + 1, agrs[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }

//    考虑事务处理的更新方法
    public int update(Connection conn,String sql, Object... agrs) {
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
}
