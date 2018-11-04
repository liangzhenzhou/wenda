package com.zhou.wenda.model;

import org.springframework.stereotype.Component;

/**
 * @author liangzhenzhou
 * @create 2018-10-29 21:47
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();
    public User getUser(){
        return users.get();
    }
    public void setUsers(User user){
        users.set(user);
    }
    public void clear(){
        users.remove();
    }
}
