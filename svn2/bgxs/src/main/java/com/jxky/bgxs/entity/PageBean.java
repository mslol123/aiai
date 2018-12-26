package com.jxky.bgxs.entity;


import java.io.Serializable;
/*
* 分页
* */
public class PageBean implements Serializable {
    //一共多少条数据
    private int count;
    //当前页数
    private int currentPage;
    //一共多少页
    private int totalPage;
    //总页数


    @Override
    public String toString() {
        return "PageBean{" +
                "count=" + count +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
