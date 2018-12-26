package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Moderator implements Serializable {
    private Integer id;

    @Override
    public String toString() {
        return "Moderator{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", user=" + user +
                ", creattime=" + creattime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer bookId;
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creattime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}