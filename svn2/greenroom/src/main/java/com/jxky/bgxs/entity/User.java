package com.jxky.bgxs.entity;

//对应user_login表
public class User {
    private Integer id;
    //电话
    private String tel;
    //密码
    private String pwd;
    //昵称
    private String nickname;
    //唯一账号
    private String onlynum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOnlynum() {
        return onlynum;
    }

    public void setOnlynum(String onlynum) {
        this.onlynum = onlynum;
    }
}
