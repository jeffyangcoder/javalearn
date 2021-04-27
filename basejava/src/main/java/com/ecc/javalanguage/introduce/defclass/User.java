package com.ecc.javalanguage.introduce.defclass;

public class User {
    //数据成员
    private String userName;
    private String infoCode;
    private String loginName;
    private Role role;

    //构造方法
    public User(String userName, String infoCode, String loginName, Role role) {
        this.userName = userName;
        this.infoCode = infoCode;
        this.loginName = loginName;
        this.role = role;
    }

    public User(String userName, String infoCode, String loginName) {
        this.userName = userName;
        this.infoCode = infoCode;
        this.loginName = loginName;
    }

    //成员方法
    public void add() {
    }

    public void delete() {
    }

    public void infoDisplay() {
        System.out.println(userName + "--" + infoCode + "--" + loginName + "--" + role.getRoleName());
    }

    public void infoDisplay(Role role) {
        System.out.println(userName + "--" + infoCode + "--" + loginName);
        System.out.println("has a role of");
        role.infoDisplay();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
