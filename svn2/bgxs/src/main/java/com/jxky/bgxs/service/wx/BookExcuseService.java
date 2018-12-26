package com.jxky.bgxs.service.wx;

import com.jxky.bgxs.dao.BookExcuseDAO;
import com.jxky.bgxs.entity.BookExcuse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookExcuseService {
    @Resource
    private BookExcuseDAO bookExcuseDAO;
    public List<BookExcuse> findUserByBookId(Integer id){
        return bookExcuseDAO.findUserByBookId(id);
    }
    public void add(BookExcuse bookExcuse){
        bookExcuseDAO.add(bookExcuse);
    }
    public void delete(Integer id){
        bookExcuseDAO.delete(id);
    }
}
