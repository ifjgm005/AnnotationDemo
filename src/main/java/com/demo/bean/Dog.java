package com.demo.bean;

import com.demo.annotation.AnnotationTest;
import com.demo.annotation.Message;

/**
 * Created by axes on 2019/9/26.
 */
@AnnotationTest("这是个dog 类")
public class Dog extends Animal{

    String name;
    String age;

    @Override

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }
}
