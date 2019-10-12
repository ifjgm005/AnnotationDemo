package com.demo.bean;

import com.demo.annotation.Message;

/**
 * Created by tuoanlan on 2019/9/26.
 */
@Message(decr = "动物类的描述", author = "zhang", age = 28)
public class Animal {
    String name;
    String age;

    @Message(decr = "获取动物名称的方法", author = "zhang", age = 28)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
