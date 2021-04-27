package com.ecc.javalanguage.introduce.thirdapi;

import com.ecc.javalanguage.introduce.defclass.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ecc.javalanguage.introduce.thirdapi.MySQLDBConnect.conn;

public class OperateRole {
    public void insert(Role role) {
        Connection conn = MySQLDBConnect.getConn();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO role(id,roleName,dataType,roleDes)" +
                "VALUES(null,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,role.getRoleName());
            pstmt.setInt(2, role.getDataType());
            pstmt.setString(3, role.getRoleDes());
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
