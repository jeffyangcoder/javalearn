package com.ecc.javalanguage.dbconnect;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Man;
import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Role;
import com.ecc.javalanguage.dbconnect.preparedstatement.crud.manForQuery;
import com.ecc.javalanguage.dbconnect.preparedstatement.crud.roleForQuery;

public class Test {
    public static void main(String[] args) {
//        new PreparedStatementCURD().update(
//              "delete from man where id = ?"
//                ,2);
//        new PreparedStatementCURD().update(
//                "insert into man(userName,infoCode,loginName,date)values(?,?,?,?)"
//                ,"yangshiwei",1905110002,"moat","2000-09-24"
//        );
//        new PreparedStatementCURD().update(
//                "update role set roleName = ? where id =?"
//                ,"yangshiwei",6
//        );
//        String sql = "select * from man where id = ?";
//
//        Man man = new manForQuery().queryForMan(sql, 1);
//
//        System.out.println(man);
        String sql = "select * from role ";
        Role role  = new roleForQuery().queryForRole(sql );
        System.out.println(role);
    }
}
