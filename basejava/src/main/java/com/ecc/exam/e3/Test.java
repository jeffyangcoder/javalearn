package com.ecc.exam.e3;

import com.ecc.exam.e3.bean.User;
import com.ecc.exam.e3.controller.OperateUser;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/6/17-15:21
 */
public class Test {
    public static void main(String[] args) {
        User lisi = new User("lisi", "1111");
        new OperateUser().insert(lisi);

        String sql="insert into user(username,password) values (?,?)";
        User user = new User("lisi", "1111");
        new OperateUser().crud(sql, user);
    }
}
