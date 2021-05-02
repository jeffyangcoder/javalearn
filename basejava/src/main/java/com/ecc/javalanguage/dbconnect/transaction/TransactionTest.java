package com.ecc.javalanguage.dbconnect.transaction;

import com.ecc.javalanguage.dbconnect.bean.UserTable;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author yangshiwei
 * @Description 引入事务处理
 * @date 2021/5/2-11:07
 */
public class TransactionTest {

    /**
     * @Description 对于数据表user_table来说：
     * AA用户给BB用户转账
     * update user_table set balance = balance - 100 where user = 'AA'
     * update user_table set balance = balance + 100 where user = 'BB'
     * @author yangshiwei
     * @date 2021/5/2 12:17
     */
    /*
     * 1、什么叫数据库事务？
     * 事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态。
     *          >一组逻辑操作单元：一个或多个DML操作
     *
     * 2、事务完全处理完使用commit，事务未处理完使用roll back回滚
     *
     * 3、数据一旦提交，就不可回滚
     *
     * 4、哪些操作会倒是数据的自动提交？
     *          > DDL操作一旦执行，都会自动提交。
     *              > set  autocommit = false 对DDL操作失效
     *          > DML 默认情况下，一旦执行就会自动提交。
     *              > 可以通过set autocommit = false的方式取消DML操作的自动提交
     *          > 默认在关闭连接的时候也会把没有提交的数据自动提交
     */
    @Test
    public void testUpdate() {
        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        update01(sql1, "AA");

//        模拟网络异常
        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        update01(sql2, "BB");
    }

    public int update01(String sql, Object... agrs) {
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

    @Test
    public void testUpdateWithTX() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

//            取消数据自动提交功能
            conn.setAutoCommit(false);
//            System.out.println(conn.getAutoCommit());
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(conn, sql1, "AA");

//        模拟网络异常
            System.out.println(10 / 0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(conn, sql2, "BB");

            System.out.println("转账成功");

//            提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtils.closeResource(conn, null);
        }
    }

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


    //*************************************************************************************
    @Test
    public void testTransactionSelect()throws  Exception{
        Connection connection = JDBCUtils.getConnection();
//        获取当前的隔离级别
        System.out.println(connection.getTransactionIsolation());
//       设置数据库的隔离级别
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//        取消自动提交数据
        connection.setAutoCommit(false);
        String sql = "select * from userTable where user = ? ";

        UserTable aa = getInstance(connection, UserTable.class, sql, "AA");

        System.out.println(aa);
    }
    @Test
    public void testTransactionUpdate()throws Exception{
        Connection conn = JDBCUtils.getConnection();
        //        取消自动提交数据
        conn.setAutoCommit(false);

        String sql = "update userTable set balance = ? where user = ?";
        update(conn,sql,1000,"AA");

        Thread.sleep(15000);

        conn.commit();
        System.out.println("修改结束");
    }
    //    通用的查询操作，用于返回数据表中的一条记录（version2.0）
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
}

