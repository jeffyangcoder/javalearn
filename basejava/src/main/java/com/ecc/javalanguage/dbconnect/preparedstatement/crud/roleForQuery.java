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
 *              针对于表的字段名与类的属性名不相同的情况，必须声明sql时，使用类的属性名来命名字段的别名。
 *              使用ResultSetMetaDate时，需要使用getColumnLabel（）来替换getColumnName（）
 *              说明：如果sql重没有给字段起别名，getColumnLabel（）获取列名
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
//                   获取列名 getColumnName(int index);
//                   获取别名getColumnLabel(int index); 没有别名就获取到列名
                    String columnName = metaData.getColumnLabel(i + 1);

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
