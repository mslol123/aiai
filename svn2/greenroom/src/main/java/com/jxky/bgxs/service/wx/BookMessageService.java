package com.jxky.bgxs.service.wx;

import com.jxky.bgxs.dao.BookMessageDAO;
import com.jxky.bgxs.dao.ChapterDAO;
import com.jxky.bgxs.entity.BookMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookMessageService {
    @Resource
    private BookMessageDAO bookMessageDAO;
    @Resource
    private ChapterDAO chapterDAO;

    public List<BookMessage> checkbook(String bookname){
        return bookMessageDAO.findBookByBookname(bookname);
    }

    public List<BookMessage> findNewBook(){
        List<BookMessage> all = bookMessageDAO.findAll();
        List<BookMessage> list = new ArrayList<>();
        for (BookMessage book:all){
            Integer count = chapterDAO.findCountByBookId(book.getBookId());
            if(count!=0&&book.getBookExamineStatus().equals("待审核")){
                list.add(book);
                System.out.println(book.getBookExamineStatus());
            }
        }
        return list;
    }

    public void agreenBook(Integer id){
        BookMessage book = bookMessageDAO.findById(id);
        book.setBookExamineStatus("审核通过");
        bookMessageDAO.updateBookMessage(book);
    }

    public BookMessage findById(Integer id){
        return bookMessageDAO.findById(id);
    }

    public List<BookMessage> findAllByAuthorId(Integer id){
        return bookMessageDAO.findAllByAuthorId(id);
    }

    public void insert(BookMessage bookMessage){
        bookMessageDAO.insert(bookMessage);
    }

    public void updateBookMessage(BookMessage bookMessage){
        bookMessageDAO.updateBookMessage(bookMessage);
    }

    public void delete(Integer id){bookMessageDAO.delete(id);}

    public List<BookMessage> findAll(){return bookMessageDAO.findAll();}

    public List<BookMessage> findBookByStatus(String bookStatus){
        return bookMessageDAO.findBookByStatus(bookStatus);
    }

    public void updateStatus(String status,Integer id){
        bookMessageDAO.updateStatus(status, id);
    }
}

