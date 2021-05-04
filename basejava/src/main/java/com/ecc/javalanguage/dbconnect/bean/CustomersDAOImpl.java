package com.ecc.javalanguage.dbconnect.bean;

import com.ecc.javalanguage.dbconnect.dao.CustomerDAO;
import com.ecc.javalanguage.dbconnect.dao.DAO;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * @author yangshiwei
 * @Description 接口的实现类
 * @date 2021/5/2-22:47
 */
public class CustomersDAOImpl extends DAO implements CustomerDAO {
    @Override
    public void insert(Connection conn, Customers customer) {
        String sql = "insert into customers(name,email,birthday)values(?,?,?)";
        update(conn, sql, customer.getName(), customer.getEmail(), customer.getBirthday());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        update(conn,sql,id);
    }

    @Override
    public void updateById(Connection conn, Customers customer) {
        String sql ="update customers set name = ?,email = ?,birthday  = ? where id = ?";
        update(conn,sql,customer.getName(), customer.getEmail(),customer.getBirthday(),customer.getId());
    }

    @Override
    public Customers getCustomersById(Connection conn, int id) {
        String sql = "select id,name,email,birthday from customers where id = ?";
        return getInstance(conn, Customers.class, sql, id);
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select * from customers";

        return getForList(conn, Customers.class, sql);

    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers ";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birthday) from customers";
        return getValue(conn,sql);
    }
}
