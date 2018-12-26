package com.qiangfeng.oasystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YongChe implements java.io.Serializable{
    private String id;
    private String reason;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;
    private Date createDate;
    private User user;
    private String processId;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "YongChe{" +
                "id='" + id + '\'' +
                ", reason='" + reason + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", createDate=" + createDate +
                ", user=" + user +
                ", processId='" + processId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
