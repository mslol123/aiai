package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTypeDAO {
    List<BookType> findAll();
}
