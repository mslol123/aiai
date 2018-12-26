package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO {
    Author findById(Integer id);
}
