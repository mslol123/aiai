package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.BookMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMessageDAO {
    List<BookMessage> findBookByBookname(String bookName);
    List<BookMessage> findBookByUserId(int id);
    List<BookMessage> findAllByAuthorId(int id);
    void updateBookMessage(BookMessage bookMessage);
    BookMessage findById(int id);
    void delete(int id);
    void insert(BookMessage bookMessage);
    List<BookMessage> findAll();
    List<BookMessage> findBookByStatus(String bookStatus);
    void updateStatus(String status,Integer id);
}
