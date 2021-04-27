package com.ecc.javalanguage.aboutClass;

import java.util.ArrayList;
import java.util.List;

//@Description 学生信息(姓名，学号，籍贯，年龄)
public class Student {
    private String stuName;
    private String stuNo;
    private String stuHome;
    private int stuAge;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }


    public String getStuHome() {
        return stuHome;
    }

    public void setStuHome(String stuHome) {
        this.stuHome = stuHome;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Student(String stuName, String stuNo, String stuHome, int stuAge) {
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.stuHome = stuHome;
        this.stuAge = stuAge;
    }

    public Student() {
    }
}
