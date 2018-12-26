package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class BookExcuse implements Serializable {
    private Integer id;
    private Integer bookId;
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creattime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;
    private String content;

    @Override
    public String toString() {
        return "BookExcuse{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", user=" + user +
                ", creattime=" + creattime +
                ", endtime=" + endtime +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
