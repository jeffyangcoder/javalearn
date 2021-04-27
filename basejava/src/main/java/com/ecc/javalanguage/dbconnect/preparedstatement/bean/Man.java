package com.ecc.javalanguage.dbconnect.preparedstatement.bean;

import java.util.Date;

/**
 * ORM编程思想
 * 对象关系映射
 * 一个数据表对应一个Java类
 * 表中的一条记录对应Java类的一个对象那个
 * 表中的一个字段对应Java类的一个属性
 */
public class Man {
    private int id;
    private String userName;
    private int infoCode;
    private String loginName;
    private Date date;

    public Man() {
        super();
    }

    public Man(int id, String userName, int infoCode, String loginName, Date date) {
        this.id = id;
        this.userName = userName;
        this.infoCode = infoCode;
        this.loginName = loginName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(int infoCode) {
        this.infoCode = infoCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", infoCode=" + infoCode +
                ", loginName='" + loginName + '\'' +
                ", date=" + date +
                '}';
    }
}
