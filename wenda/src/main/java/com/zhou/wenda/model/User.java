package com.zhou.wenda.model;

/**
 * @author liangzhenzhou
 * @create 2018-10-18 22:53
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public String getDescription() {
        return "This is " + name;
    }
}
