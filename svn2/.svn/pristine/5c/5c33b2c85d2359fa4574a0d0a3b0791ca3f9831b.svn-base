package com.jxky.bgxs.service.wx;

import com.jxky.bgxs.dao.BookTypeDAO;
import com.jxky.bgxs.entity.BookType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookTypeService {
    @Resource
    private BookTypeDAO bookTypeDAO;

    public List<BookType> findAll(){
        return bookTypeDAO.findAll();
    }
}

