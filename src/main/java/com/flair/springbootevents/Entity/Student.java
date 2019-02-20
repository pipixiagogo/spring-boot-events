package com.flair.springbootevents.Entity;

import com.flair.springbootevents.annotation.SortField;

public class Student {

    @SortField
    private String name;
    @SortField
    private Integer age;
    private String home;
    private String address;

    public Student(String name, Integer age, String home) {
        this.name = name;
        this.age = age;
        this.home = home;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", home='" + home + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
