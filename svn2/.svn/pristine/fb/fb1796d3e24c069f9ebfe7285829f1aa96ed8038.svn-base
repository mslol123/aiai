package com.jxky.bgxs.service.wjt;

import com.jxky.bgxs.dao.BookShelfDAO;
import com.jxky.bgxs.entity.BookShelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookShelfService {
    @Autowired
    private BookShelfDAO bookShelfDAO;
    public void addShelf(int bookId,int userId){

            bookShelfDAO.insert(bookId,userId);

    }
    /**
     * author zsy
     * 查询我的书架 根据用户userId查询
     * */
    public List<BookShelf> findMyBookShelf(Integer userId){
        return bookShelfDAO.findMyBookShelf(userId);
    }
}
