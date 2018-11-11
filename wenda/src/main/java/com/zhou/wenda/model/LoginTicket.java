package com.zhou.wenda.model;

import java.util.Date;

/**
 * @author liangzhenzhou
 * @create 2018-10-29 21:33
 */
public class LoginTicket {
    private int id;
    private int userId;
    private Date expired;
    private int status;//0 able  1 unable
    private String ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
