package com.ecc.exercise.ex3;

import com.ecc.exercise.ex3.CRUD.CURD;
import com.ecc.exercise.ex3.CRUD.Query;
import com.ecc.exercise.ex3.bin.Customers;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/26-11:16
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        try {

//        增删改测试(由于增删改不需要返回结果，故作为一类函数处理)
            CURD runner = new CURD();
            conn = JDBCUtils.getConnection();
            String sql = "insert into bookstore.customers ( name, email, birthday) values (?,?,?)";

//            此处的update为操作影响的行数
            int update = runner.update(conn, sql, "kkk", "caixukun@outlook.com", "1999-09-23");
            System.out.println("成功修改了 " + update + " 行数据" );


//            查询测试
//            使用德鲁伊提供的查询函数
            QueryRunner runner1 = new QueryRunner();
            String sql1 = "select id,name,email,birthday from customers where id = ?";
//            BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录
            BeanHandler<Customers> beanHandler = new BeanHandler<Customers>(Customers.class);
            Customers customers = runner1.query(conn, sql1, beanHandler, 5);
            System.out.println(customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }

    }

}
