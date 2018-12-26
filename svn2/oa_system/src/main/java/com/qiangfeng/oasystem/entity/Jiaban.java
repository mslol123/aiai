package com.qiangfeng.oasystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Jiaban implements Serializable {
    private String id;
    private String reason;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;
    private Date createDate;
    private User user;
    private String processId;
    private String jiabanStatus;

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

    public String getJiabanStatus() {
        return jiabanStatus;
    }

    public void setJiabanStatus(String jiabanStatus) {
        this.jiabanStatus = jiabanStatus;
    }
}
