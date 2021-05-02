package com.ecc.javalanguage.dbconnect.bean;

import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.Assert.*;

public class CustomersDAOImplTest extends CustomersDAOImpl {

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Customers customers = new Customers(2, "yangshiwei", "872802292@qq.com", new Date(43534646435L));
        insert(conn,customers);
    }

    @Test
    public void testDeleteById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        deleteById(conn, 1);
    }

    @Test
    public void testUpdateById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Customers customers = new Customers(2, "yangshiwei", "7777@qq.com", new Date(43534646435L));
        updateById(conn,customers);
    }

    @Test
    public void testGetCustomersById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Customers customersById = getCustomersById(conn, 2);
        System.out.println(customersById);

    }

    @Test
    public void testGetAll() {

    }

    @Test
    public void testGetCount() {
    }

    @Test
    public void testGetMaxBirth() {
    }
}