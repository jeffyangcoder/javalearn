package com.ecc.javalanguage.dbconnect.bean;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/2-12:26
 */
public class UserTable {
     private String user;
     private String password;
     private int balance;

    @Override
    public String toString() {
        return "UserTable{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public UserTable(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    public UserTable() {
    }
}
