package com.jxky.bgxs.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;
    private Integer userId;
    private Integer bookMessageId;
    private String commentContent;
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
        creattime = creattime;
    }
}
