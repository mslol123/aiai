package com.jxky.bgxs.service.wjt;

import com.jxky.bgxs.dao.BookShelfDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookShelfService {
    @Autowired
    private BookShelfDAO bookShelfDAO;
    public void addShelf(int bookId,int userId){

            bookShelfDAO.insert(bookId,userId);


    }
}
