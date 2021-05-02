package com.ecc.javalanguage.dbconnect.preparedstatement.crud;

import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author yangshiwei
 * @Description 使用PreparedStatement实现批量数据的操作
 *              update,delete本身就具有批量操作的效果
 *
 * @date 2021/4/30-13:22
 */
public class InsertTest {
    @Test
    //批量操作
    public void test1(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into Goods (name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 2000; i++) {
                ps.setObject(1,"name_" + i);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("花费时间：" + ((end - start) / 1000.00));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);

        }
    }
    @Test
    public void test2(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
//            不允许自动提交数据
            conn.setAutoCommit(false);
            String sql = "insert into Goods (name)values(?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 2000; i++) {
                ps.setObject(1,"name_" + i);
//                拼串
                ps.addBatch();
                if (i % 200 == 0) {
                    ps.execute();
//                    把执行完的串清除
                    ps.clearBatch();
                }

            }
            conn.commit();
            long end = System.currentTimeMillis();

            System.out.println("花费时间：" + ((end - start) / 1000.00));

//            提交数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);

        }
    }
}
