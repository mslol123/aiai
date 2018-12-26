package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单表
 */
public class Indent {
    //订单号
    private String number;
    //用户id
    private Integer userId;
    //订单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;
    //商品名字
    private String name;
    //商品价格
    private double price;
    //订单状态
    private String state;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
