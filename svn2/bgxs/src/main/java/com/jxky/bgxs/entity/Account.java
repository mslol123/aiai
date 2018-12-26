package com.jxky.bgxs.entity;

import java.io.Serializable;

/*
* 账户表
* */
public class Account implements Serializable {
    //账户id
    private String accountId;
    //账户巴哥币
    private int accountNum;
    //月票
    private int monthticket;
    //推荐票
    private int recomticket;
    //账户类型
    private String accountType;
    //累计消费
    private int accountConsume;
    //用户id（关联用户id）
    private Integer userId;

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountNum=" + accountNum +
                ", monthticket=" + monthticket +
                ", recomticket=" + recomticket +
                ", accountType='" + accountType + '\'' +
                ", accountConsume=" + accountConsume +
                ", userId=" + userId +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public int getMonthticket() {
        return monthticket;
    }

    public void setMonthticket(int monthticket) {
        this.monthticket = monthticket;
    }

    public int getRecomticket() {
        return recomticket;
    }

    public void setRecomticket(int recomticket) {
        this.recomticket = recomticket;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountConsume() {
        return accountConsume;
    }

    public void setAccountConsume(int accountConsume) {
        this.accountConsume = accountConsume;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
