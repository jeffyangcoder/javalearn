package com.ecc.javalanguage.dbconnect;

import com.ecc.javalanguage.dbconnect.preparedstatement.bean.Users;
import com.ecc.javalanguage.dbconnect.preparedstatement.crud.CURD;
import com.ecc.javalanguage.dbconnect.preparedstatement.crud.Query;
import com.ecc.javalanguage.dbconnect.util.JDBCUtils;
import com.ecc.javalanguage.introduce.defclass.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.util.Scanner;

/**
 * @author yangshiwei
 * @Description 完成课程给的练习，练练手
 * @date 2021/4/28-19:45
 */
public class Homework {

    public static void main01(String[] args) {
        /**
         * @Description 增加一个元组
         * @author yangshiwei
         * @date 2021/4/29 17:03
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名： ");
        String name = scanner.next();
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        System.out.print("请输入生日：");
        String birthday = scanner.next();

        String sql = "insert into customers(name,birthday,email)values(?,?,?) ";
        int update = new CURD().update(sql, name, birthday, email);

        if (update > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public static void main02(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名: ");
        String userName = scanner.next();

        System.out.print("请输入密码: ");
        String password = scanner.next();

        System.out.print("请输入邮件: ");
        String email = scanner.next();

//        4.使用JDBC实现往用户表中添加1个用户
        String sql = "insert into users (userName,password,email) values(?,?,?)";
        int update = new CURD().update(sql, userName, password, email);
        if (update > 0) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

    public static void main03(String[] args) {
        /**
         * @Description 查询
         * @author yangshiwei
         * @date 2021/4/29 17:05
         * @param args
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("please input you userName: ");
        String userName = scanner.next();
        System.out.println("please input your password");
        String password = scanner.next();

        String sql = "select id,username userName,password, email from users where userName= ? AND password = ?";
        String sql1 = "select id,username userName,password, email from users where userName= ?";
        Users user = new Query().getInstance(Users.class, sql, userName, password);
        Users user1 = new Query().getInstance(Users.class, sql1, userName);
        if (user != null) {
            System.out.println(userName + " login success");
        } else if (user1 != null && user == null) {
            System.out.println(userName + " password wrong");
        } else {
            System.out.println("Can't find " + userName);
        }
    }

    public static void main04(String[] args) {
        /**
         * @Description 删除一个元素
         * @author yangshiwei
         * @date 2021/4/29 17:05
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入你要删除的名字： ");
        String userName = scanner.next();

        String sql1 = "delete from users where userName = ?";
        int update = new CURD().update(sql1, userName);
        if (update > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("查无此人");
        }
    }

    /**
     * @Description 测试添加Blob类型的数据
     * @author yangshiwei
     * @date 2021/4/30 11:13
     */
    public static void main05(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name: ");
        String name = scanner.next();
        System.out.println("birth: ");
        String birth = scanner.next();
        System.out.println("email: ");
        String email = scanner.next();
        System.out.println("photo: ");
        String photo = scanner.next();
        FileInputStream photoStream = null;
        try {
            photoStream = new FileInputStream(new File(photo));
            String sql = "insert into star (name,birth,email,photo) values(?,?,?,?)";

            int update = new CURD().update(sql, name,birth, email, photoStream);

            if (update > 0) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
