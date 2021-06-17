package com.ecc.exam.e3.controller;

import com.ecc.exam.e3.utils.JDBCUtils;
import com.ecc.exam.e3.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/6/17-15:11
 */
public class OperateUser {
    public void insert(User user){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into user(username,password) values(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, user.getUserName());
            ps.setObject(2, user.getPassword());
            ps.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void crud(String sql,User user){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setObject(1, user.getUserName());
            ps.setObject(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public User query(String sql,Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < args.length ;i++) {
                ps.setObject(i+1, args[i]);
            }
            User user = (User) ps.executeQuery(sql);
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
