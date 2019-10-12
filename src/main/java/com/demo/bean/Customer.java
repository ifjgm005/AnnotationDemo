package com.demo.bean;

import com.demo.annotation.Column;
import com.demo.annotation.Table;

/**
 * Created by axes on 2019/10/12.
 */
@Table("user")
public class Customer {
    //id
    @Column("id")
    private int id;

    //姓名
    @Column("user_name")
    private String userName;

    //年龄
    @Column("age")
    private int age;

    //城市
    @Column("city")
    private String city;

    //邮箱
    @Column("email")
    private String email;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
