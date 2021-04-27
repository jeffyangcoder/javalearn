package com.ecc.javalanguage.dbconnect.preparedstatement.crud;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Role;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author yangshiwei
 * @Description 对role表的查询常规操作
 * @date 2021/4/27-19:59
 */
public class roleForQuery {
    public Role queryForRole(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
//        1:
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

//        2:
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1,args[i]);
            }

            //        3:
            rs = ps.executeQuery();

//      4:
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (rs.next()){
    //            5:
                Role role = new Role();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = metaData.getColumnName(i + 1);

                    Field declaredField = Role.class.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(role,columnValue);
                }
                return role;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
