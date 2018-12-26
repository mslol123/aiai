package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.BookExcuse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookExcuseDAO {
    List<BookExcuse> findUserByBookId(Integer id);
}
