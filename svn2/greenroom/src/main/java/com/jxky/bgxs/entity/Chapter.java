package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
* 章节表
* */
public class Chapter {
    //章节id
    private Integer chapterId;
    //章节路径
    private String chapterPath;
    //章节作者（关联作者id）
    private int chapterAuthorId;
    //章节书籍（关联书籍id）
    private int chapterBookId;
    //章节名称
    private String chapterName;
    //章节创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chapterCreatetime;
    //作者寄语
    private String chapterMessage;
    //章节字数
    private int chapterWords;
    //章节点赞数
    private int chapterGivenum;
    //章节发布模式
    private String chapterReleaseModel;
    //章节发布模式
    private String chapterReleaseMode;
    //章节金额
    private int chapterMoney;
    //审核状态
    private String chapterStatus;

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId=" + chapterId +
                ", chapterPath='" + chapterPath + '\'' +
                ", chapterAuthorId=" + chapterAuthorId +
                ", chapterBookId=" + chapterBookId +
                ", chapterName='" + chapterName + '\'' +
                ", chapterCreatetime=" + chapterCreatetime +
                ", chapterMessage='" + chapterMessage + '\'' +
                ", chapterWords=" + chapterWords +
                ", chapterGivenum=" + chapterGivenum +
                ", chapterReleaseModel='" + chapterReleaseModel + '\'' +
                ", chapterReleaseMode='" + chapterReleaseMode + '\'' +
                ", chapterMoney=" + chapterMoney +
                ", chapterStatus='" + chapterStatus + '\'' +
                '}';
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterPath() {
        return chapterPath;
    }

    public void setChapterPath(String chapterPath) {
        this.chapterPath = chapterPath;
    }

    public int getChapterAuthorId() {
        return chapterAuthorId;
    }

    public void setChapterAuthorId(int chapterAuthorId) {
        this.chapterAuthorId = chapterAuthorId;
    }

    public int getChapterBookId() {
        return chapterBookId;
    }

    public void setChapterBookId(int chapterBookId) {
        this.chapterBookId = chapterBookId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Date getChapterCreatetime() {
        return chapterCreatetime;
    }

    public void setChapterCreatetime(Date chapterCreatetime) {
        this.chapterCreatetime = chapterCreatetime;
    }

    public String getChapterMessage() {
        return chapterMessage;
    }

    public void setChapterMessage(String chapterMessage) {
        this.chapterMessage = chapterMessage;
    }

    public int getChapterWords() {
        return chapterWords;
    }

    public void setChapterWords(int chapterWords) {
        this.chapterWords = chapterWords;
    }

    public int getChapterGivenum() {
        return chapterGivenum;
    }

    public void setChapterGivenum(int chapterGivenum) {
        this.chapterGivenum = chapterGivenum;
    }

    public String getChapterReleaseModel() {
        return chapterReleaseModel;
    }

    public void setChapterReleaseModel(String chapterReleaseModel) {
        this.chapterReleaseModel = chapterReleaseModel;
    }

    public String getChapterReleaseMode() {
        return chapterReleaseMode;
    }

    public void setChapterReleaseMode(String chapterReleaseMode) {
        this.chapterReleaseMode = chapterReleaseMode;
    }

    public int getChapterMoney() {
        return chapterMoney;
    }

    public void setChapterMoney(int chapterMoney) {
        this.chapterMoney = chapterMoney;
    }

    public String getChapterStatus() {
        return chapterStatus;
    }

    public void setChapterStatus(String chapterStatus) {
        this.chapterStatus = chapterStatus;
    }
}
