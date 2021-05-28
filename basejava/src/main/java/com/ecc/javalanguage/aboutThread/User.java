package com.ecc.javalanguage.aboutThread;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/28-14:15
 */
public class User {
    private int id;
    private int name;

    public User() {
        this.id = 0;
        this.name = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
