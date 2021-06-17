package com.ecc.web.util;

import com.ecc.javalanguage.introduce.defclass.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperateRole {
    public void insert(Role role) {
        Connection conn = MySQLDBConnect.getConn();
        PreparedStatement stmts = null;
        String sql = "INSERT INTO role(id,roleName,dataType,roleDes)" +
                "VALUES(null,?,?,?)";
        try {
            stmts = conn.prepareStatement(sql);
            stmts.setString(1,role.getRoleName());
            stmts.setInt(2, role.getDataType());
            stmts.setString(3, role.getRoleDes());
            stmts.executeUpdate();
            System.out.println("Success" + role);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
