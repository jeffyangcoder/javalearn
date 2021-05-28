package com.ecc.exercise.ex3.utils;

import com.ecc.javalanguage.introduce.defclass.Role;
import com.ecc.javalanguage.introduce.defclass.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ecc.exercise.ex3.utils.MySQLDBConnect.conn;;

public class DBControl {
    //遍历role表
    public static void roleRead() {
        Statement stmt = null;
        String sql = "SELECT id,roleName,datatype,roleDes FROM role";
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String roleName = rs.getString("roleName");
                String dataType = rs.getString("dataType");
                String roleDes = rs.getString("roleDes");

                System.out.print("ID: " + id);
                System.out.print(",roleName: " + roleName);
                System.out.print(",dataType: " + dataType);
                System.out.print(",roleDes: " + roleDes + "\n");
            }
            rs.close();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //insert new data

    public static void insert(int id, Role role) {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO role(id,roleName,dataType,roleDes)" +
                "VALUES(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setString(2,role.getRoleName());
            pstmt.setInt(3,role.getDataType());
            pstmt.setString(4, role.getRoleDes());
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(User user)
    {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO user(id,userName,infoCode,loginName)" +
                "VALUES(null,?,?,?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getInfoCode());
            preparedStatement.setString(4, user.getLoginName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
