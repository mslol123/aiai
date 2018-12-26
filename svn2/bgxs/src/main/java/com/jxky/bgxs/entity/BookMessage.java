package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/*
* 书籍详情表
* */
public class BookMessage implements Serializable {
    //书籍id
    private int bookId;
    //书籍名称
    private String bookName;
    //书籍图片路径
    private String bookImage;
    //书籍作者（关联作者id）
    private Author author;
    //书籍创建时间
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date bookCreattime;
    //书籍类型id（关联书籍类型表）
    private BookType bookType;
    //书籍编号
    private String bookNum;
    //书籍作品首字母
    private String bookFirstletter;
    //书籍关键字
    private String bookKeyword;
    //书籍内容简介
    private String bookContent;
    //书籍作品寄语
    private String bookWord;
    //书籍审核状态
    private String bookExamineStatus;
    //书籍是否完结
    private String bookIsEnd;
    //书籍单月到来价值
    private Integer bookPay;
    //拒绝缘由
    private String refuseWord;
    //拒绝时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date examineTime;
    //是否删除
    private Integer watch;

    //草稿箱数量
    private Integer num;
    //书籍售价
    private Integer sales;
    //对应的章节信息
    private Chapter chapter;

    @Override
    public String toString() {
        return "BookMessage{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", author=" + author +
                ", bookCreattime=" + bookCreattime +
                ", bookType=" + bookType +
                ", bookNum='" + bookNum + '\'' +
                ", bookFirstletter='" + bookFirstletter + '\'' +
                ", bookKeyword='" + bookKeyword + '\'' +
                ", bookContent='" + bookContent + '\'' +
                ", bookWord='" + bookWord + '\'' +
                ", bookExamineStatus='" + bookExamineStatus + '\'' +
                ", bookIsEnd='" + bookIsEnd + '\'' +
                ", bookPay=" + bookPay +
                ", refuseWord='" + refuseWord + '\'' +
                ", examineTime=" + examineTime +
                ", watch=" + watch +
                ", num=" + num +
                ", sales=" + sales +
                ", chapter=" + chapter +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getBookCreattime() {
        return bookCreattime;
    }

    public void setBookCreattime(Date bookCreattime) {
        this.bookCreattime = bookCreattime;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookFirstletter() {
        return bookFirstletter;
    }

    public void setBookFirstletter(String bookFirstletter) {
        this.bookFirstletter = bookFirstletter;
    }

    public String getBookKeyword() {
        return bookKeyword;
    }

    public void setBookKeyword(String bookKeyword) {
        this.bookKeyword = bookKeyword;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public String getBookWord() {
        return bookWord;
    }

    public void setBookWord(String bookWord) {
        this.bookWord = bookWord;
    }

    public String getBookExamineStatus() {
        return bookExamineStatus;
    }

    public void setBookExamineStatus(String bookExamineStatus) {
        this.bookExamineStatus = bookExamineStatus;
    }

    public String getBookIsEnd() {
        return bookIsEnd;
    }

    public void setBookIsEnd(String bookIsEnd) {
        this.bookIsEnd = bookIsEnd;
    }

    public Integer getBookPay() {
        return bookPay;
    }

    public void setBookPay(Integer bookPay) {
        this.bookPay = bookPay;
    }

    public String getRefuseWord() {
        return refuseWord;
    }

    public void setRefuseWord(String refuseWord) {
        this.refuseWord = refuseWord;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
