package com.ecc.javalanguage.introduce.thirdapi;


import com.ecc.javalanguage.introduce.defclass.Role;


public class test {
    public static void main(String[] args) {
        Role role = new Role("lin", 1, "stu");

        new OperateRole().insert(role);
    }
}
