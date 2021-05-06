package com.ggf.Ioc2.pojo;

public class User {

    String name;
    son son;

    public User(String name, com.ggf.Ioc2.pojo.son son) {
        this.name = name;
        this.son = son;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
class son{
    int age;

    public void setAge(String age) {
    }
}