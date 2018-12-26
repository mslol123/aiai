package com.jxky.bgxs.entity;
/*
* 用户订阅表
* */
public class Subscribe {
    //订阅的用户（关联用户id）
    private int userId;
    //订阅的章节（关联章节id）
    private int chapterId;

    @Override
    public String toString() {
        return "Subscribe{" +
                "userId=" + userId +
                ", chapterId=" + chapterId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }
}
