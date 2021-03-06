package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
* 用户消息表
* */
public class Message implements Serializable {
    //消息id
    private int messageId;
    //发送消息用户id（关联用户表id）
    private User sendUser;
    //接收消息用户id（关联用户表id）
    private User acceptUser;
    //消息主题
    private String messageTheme;
    //消息内容
    private String messageContent;
    //消息类型id（关联消息类型表id）
    private MessageType messageType;
    //消息发送时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date messageCreateTime;

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sendUser=" + sendUser +
                ", acceptUser=" + acceptUser +
                ", messageTheme='" + messageTheme + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageType=" + messageType +
                ", messageCreateTime=" + messageCreateTime +
                '}';
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public User getAcceptUser() {
        return acceptUser;
    }

    public void setAcceptUser(User acceptUser) {
        this.acceptUser = acceptUser;
    }

    public String getMesageTheme() {
        return messageTheme;
    }

    public void setMesageTheme(String mesageTheme) {
        this.messageTheme = mesageTheme;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTheme() {
        return messageTheme;
    }

    public void setMessageTheme(String messageTheme) {
        this.messageTheme = messageTheme;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
