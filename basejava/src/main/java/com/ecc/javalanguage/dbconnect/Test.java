package com.ecc.javalanguage.dbconnect;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Man;
import com.ecc.javalanguage.dbconnect.preparedstatement.crud.Query;

import java.util.Scanner;

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
//        String sql = "select * from man ";
//        Man man  = new QueryTest().getInstance(Man.class,sql);
//        System.out.println(man);

//        String sql = "select * from man";
//        List<Man> men = new QueryTest().getForList(Man.class, sql);
//        for(Man op : men){
//            System.out.println(op);
//        }
//        men.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String userName = scanner.nextLine();
        System.out.println("请输入登录名");
        String loginName = scanner.nextLine();

        String sql = "select * from man where userName = ? AND loginName = ?";
        Man man = new Query().getInstance(Man.class, sql,userName,loginName);
        if (man == null) {
        System.out.println("登录失败");
    }else
            System.out.println("登录成功");
}
}
