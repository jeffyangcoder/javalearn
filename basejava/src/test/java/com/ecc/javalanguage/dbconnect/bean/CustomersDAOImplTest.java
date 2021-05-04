package com.ecc.javalanguage.dbconnect.bean;

import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomersDAOImplTest extends CustomersDAOImpl {

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customers customers = new Customers(2, "yangshiwei", "872802292@qq.com", new Date(43534646435L));
            insert(conn, customers);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败");
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testDeleteById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            deleteById(conn, 1);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testUpdateById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customers customers = new Customers(2, "yangshiwei", "7777@qq.com", new Date(43534646435L));
            updateById(conn, customers);
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testGetCustomersById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customers customersById = getCustomersById(conn, 2);
            System.out.println(customersById);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }

    @Test
    public void testGetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Customers> customersList = getAll(conn);
            customersList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testGetCount() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println("You have" + getCount(conn) + " customers") ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testGetMaxBirth() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            java.util.Date maxBirth = getMaxBirth(conn);
            System.out.println("Max birthday is " + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}