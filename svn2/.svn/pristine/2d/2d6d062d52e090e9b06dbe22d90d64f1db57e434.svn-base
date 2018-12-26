package com.jxky.bgxs.service.wx;

import com.jxky.bgxs.dao.BookMessageDAO;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.PageBean;
import com.jxky.bgxs.util.Constants;
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

    public BookMessage findById(Integer id){
        return bookMessageDAO.findById(id);
    }

    public List<BookMessage> findAllByAuthorId(Integer id,Integer page){
        int firstResult = (page-1) * 5;
        int count = bookMessageDAO.findCount(id);
        int pageCount = count % Constants.PAGE_SIZE == 0 ? count / Constants.PAGE_SIZE : count / Constants.PAGE_SIZE + 1;
        return bookMessageDAO.findAllByAuthorId(id,firstResult,Constants.PAGE_SIZE);
    }
    public List<BookMessage> findAllByAuthor(Integer id){
        return bookMessageDAO.findAllByAuthor(id);
    }

    public void insert(BookMessage bookMessage){
        bookMessageDAO.insert(bookMessage);
    }

    public void updateBookMessage(BookMessage bookMessage){
        bookMessageDAO.updateBookMessage(bookMessage);
    }

    public void delete(Integer id){bookMessageDAO.delete(id);}

    public List<BookMessage> findAll(){return bookMessageDAO.findAll();}

    public List<BookMessage> findRefuseById(Integer id){
        List<BookMessage> refuse = bookMessageDAO.findRefuseById(id);
        List<BookMessage> books = new ArrayList<>();
        for (BookMessage book:refuse){
            if (book.getBookExamineStatus().equals("审核未通过") && book.getWatch()==0){
                books.add(book);
            }
        }
        return books;
    }

    public void updateWatch(Integer id){
        BookMessage message = bookMessageDAO.findById(id);
        message.setWatch(1);
        bookMessageDAO.updateBookMessage(message);
    }
    public PageBean getPage(Integer id,int page){
        int count = bookMessageDAO.findCount(id);
        int pageCount = count % Constants.PAGE_SIZE == 0 ? count / Constants.PAGE_SIZE : count / Constants.PAGE_SIZE + 1;
        PageBean pageBean = new PageBean();
        pageBean.setCount(count);
        pageBean.setCurrentPage(page);
        pageBean.setTotalPage(pageCount);
        return pageBean;
    }
}

