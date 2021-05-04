package com.ecc.javalanguage.dbconnect.util;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yangshiwei
 * @Description Apache DBUtils测试
 * @date 2021/5/4-23:17
 */
public class CRUDUtils {
    @Test
    public void testInsert(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql= "insert into customers (name,email,birthday)values(?,?,?)";
            int update = runner.update(conn, sql, "蔡徐坤", "caixukun@outlook.com", "1999-09-23");
            System.out.println(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
