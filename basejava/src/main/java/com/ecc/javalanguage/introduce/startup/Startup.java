package com.ecc.javalanguage.introduce.startup;

import com.ecc.javalanguage.datatype.EquationRoots;
import com.ecc.javalanguage.introduce.defclass.User;
import com.ecc.javalanguage.introduce.defclass.Role;
import com.ecc.javalanguage.introduce.thirdapi.DBControl;
import com.ecc.javalanguage.introduce.thirdapi.OperateRole;

import java.util.ArrayList;

public class Startup {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        //
        //
        // Role role = new Role("admin",1,"manager");
        //  User user = new User("zhangs","hello","user",role);
        //  user.infoDisplay();
        //
        //
        // int b = -6;
        // int a = Math.abs(b);
        // System.out.println("b is" + b);
        // System.out.println("b's abs is " + a);
        // 注释 基本数据类型，变量，表达式和运算符，流程控制（循环，选择）
        Role role = new Role("admin", 2, "manager");
        User user1 = new User("zhangs1", "hello", "user", role);
        User user2 = new User("zhangs2", "hello", "user", role);
        User user3 = new User("zhangs3", "hello", "user", role);

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        OperateRole operateRole = new OperateRole();
        operateRole.insert(role);
        DBControl.roleRead();


        EquationRoots equationRoots = new EquationRoots(1, 2, 1);
        int[] result = equationRoots.getRoot();
        //double[] result = EquationRoots2.getRoot(9,8,1);
        for (int item : result) {
            System.out.println("root is " + item);
        }
    }
}

