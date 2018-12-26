package com.jxky.bgxs.entity;

import java.io.Serializable;

/*
* 作者表
* */
public class Author implements Serializable {
    //作者id（用户id）
    private int authorId;
    //作者真实姓名
    private String authorTruename;
    //作者身份证号
    private String authorIDnumber;
    //作者邮政编码
    private String authorPost;
    //作者登录密码
    private String authorPassword;
    //用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorTruename='" + authorTruename + '\'' +
                ", authorIDnumber='" + authorIDnumber + '\'' +
                ", authorPost='" + authorPost + '\'' +
                ", authorPassword='" + authorPassword + '\'' +
                ", user=" + user +
                '}';
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorTruename() {
        return authorTruename;
    }

    public void setAuthorTruename(String authorTruename) {
        this.authorTruename = authorTruename;
    }

    public String getAuthorIDnumber() {
        return authorIDnumber;
    }

    public void setAuthorIDnumber(String authorIDnumber) {
        this.authorIDnumber = authorIDnumber;
    }

    public String getAuthorPost() {
        return authorPost;
    }

    public void setAuthorPost(String authorPost) {
        this.authorPost = authorPost;
    }

    public String getAuthorPassword() {
        return authorPassword;
    }

    public void setAuthorPassword(String authorPassword) {
        this.authorPassword = authorPassword;
    }
}
