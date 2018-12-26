package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.BookShelf;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookShelfDAO {
    void insert(@Param("bookId") int bookId,@Param("id") int id);
    List<BookShelf> findMyBookShelf(Integer userId);
}
