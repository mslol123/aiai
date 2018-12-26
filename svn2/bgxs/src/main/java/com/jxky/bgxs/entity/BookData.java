package com.jxky.bgxs.entity;

import java.io.Serializable;

/*
* 书籍统计数据
* */
public class BookData implements Serializable {
    //书籍id
    private int bookId;
    //书籍销售数
    private int bookSales;
    //书籍月票数
    private int bookTicket;
    //书籍点击数
    private int bookClick;
    //书籍收藏数
    private int bookCollection;
    //书籍字数
    private int bookWords;
    //书籍金额（每个章节金额的总和）
    private int bookMoney;
    //书籍订阅数
    private int bookSubscribe;
    //书籍信息(关联书籍信息)
    private BookMessage bookMessage;
    //书籍类型(关联书籍类型)
    private BookType bookType;


    @Override
    public String toString() {
        return "BookData{" +
                "bookId=" + bookId +
                ", bookSales=" + bookSales +
                ", bookTicket=" + bookTicket +
                ", bookClick=" + bookClick +
                ", bookCollection=" + bookCollection +
                ", bookWords=" + bookWords +
                ", bookMoney=" + bookMoney +
                ", bookSubscribe=" + bookSubscribe +
                ", bookMessage=" + bookMessage +
                ", bookType=" + bookType +
                '}';
    }

    public BookMessage getBookMessage() {
        return bookMessage;
    }

    public void setBookMessage(BookMessage bookMessage) {
        this.bookMessage = bookMessage;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookSales() {
        return bookSales;
    }

    public void setBookSales(int bookSales) {
        this.bookSales = bookSales;
    }

    public int getBookTicket() {
        return bookTicket;
    }

    public void setBookTicket(int bookTicket) {
        this.bookTicket = bookTicket;
    }

    public int getBookClick() {
        return bookClick;
    }

    public void setBookClick(int bookClick) {
        this.bookClick = bookClick;
    }

    public int getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(int bookCollection) {
        this.bookCollection = bookCollection;
    }

    public int getBookWords() {
        return bookWords;
    }

    public void setBookWords(int bookWords) {
        this.bookWords = bookWords;
    }

    public int getBookMoney() {
        return bookMoney;
    }

    public void setBookMoney(int bookMoney) {
        this.bookMoney = bookMoney;
    }

    public int getBookSubscribe() {
        return bookSubscribe;
    }

    public void setBookSubscribe(int bookSubscribe) {
        this.bookSubscribe = bookSubscribe;
    }
}
