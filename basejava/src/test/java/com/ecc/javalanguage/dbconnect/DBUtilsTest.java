package com.ecc.javalanguage.dbconnect;

import com.alibaba.druid.util.JdbcUtils;
import com.ecc.javalanguage.dbconnect.bean.Customers;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/4-23:19
 */
public class DBUtilsTest {
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();
            String sql = "insert into bookstore.customers ( name, email, birthday) values (?,?,?)";
            int update = runner.update(conn, sql, "kkk", "caixukun@outlook.com", "1999-09-23");
            System.out.println(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
    @Test
    public void testQuery(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birthday from customers where id = ?";
//            BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录
            BeanHandler<Customers> beanHandler = new BeanHandler<Customers>(Customers.class);
            Customers customers = runner.query(conn, sql, beanHandler, 2);
            System.out.println(customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testQueryList(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birthday from customers where id > ?";
//          BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中多条记录的一个集合
            BeanListHandler<Customers> customersBeanListHandler = new BeanListHandler<>(Customers.class);
            List<Customers> customersList = runner.query(conn, sql, customersBeanListHandler, 2);
            customersList.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testQueryMap(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birthday from customers where id = ?";
//          MapHandler:是ResultSetHandler接口的实现类，用于封装表中多条记录的一个集合
            MapHandler mapHandler = new MapHandler();
            Map<String, Object> query = runner.query(conn, sql, mapHandler, 2);
            System.out.println(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testQueryMapList(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birthday from customers where id > ?";
//          MapListHandler:是ResultSetHandler接口的实现类，用于封装表中多条记录的一个集合
            MapListHandler mapListHandler = new MapListHandler();
            List<Map<String, Object>> query = runner.query(conn, sql, mapListHandler, 2);
            query.forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    /*
     * @Description 特殊值的查询
     * @author yangshiwei
     * @date 2021/5/5 13:32
     */
    @Test
    public void testQuery2(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();

            String sql = "select count(*) from customers";
            ScalarHandler customersScalarHandler = new ScalarHandler();
            Long count = (Long) runner.query(conn, sql, customersScalarHandler);
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
    @Test
    public void testQuery3(){
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection();

            String sql = "select MAX(birthday) from customers";
            ScalarHandler customersScalarHandler = new ScalarHandler();
            Date count = (Date) runner.query(conn, sql, customersScalarHandler);
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
