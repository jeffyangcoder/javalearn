package com.ecc.javalanguage.dbconnect.preparedstatement.bean;

import java.sql.Blob;
import java.sql.Date;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/4/30-10:55
 */
public class Star {
    int id;
    String name;

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", photo=" + photo +
                '}';
    }

    String email;
    Date birth;
    Blob photo;

    public Star(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Star(int id, String name, String email, Date birth, Blob photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.photo = photo;
    }

    public Star() {
    }
}
