package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer commentId;
    private Integer userId;
    private String image;
    private String name;
    private Integer bookMessageId;
    private String commentContent;
    private String bookName;
    private String commentTheme;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmm:ss")
    private Date creattime;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", bookMessageId=" + bookMessageId +
                ", commentContent='" + commentContent + '\'' +
                ", creattime=" + creattime +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCommentTheme() {
        return commentTheme;
    }

    public void setCommentTheme(String commentTheme) {
        this.commentTheme = commentTheme;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookMessageId() {
        return bookMessageId;
    }

    public void setBookMessageId(Integer bookMessageId) {
        this.bookMessageId = bookMessageId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}
