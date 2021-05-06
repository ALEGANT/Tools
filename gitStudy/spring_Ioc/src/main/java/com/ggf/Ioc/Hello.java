package com.ggf.Ioc;

public class Hello implements Bean {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }

    @Override
    public void work() {
        System.out.println(toString());
    }
}
