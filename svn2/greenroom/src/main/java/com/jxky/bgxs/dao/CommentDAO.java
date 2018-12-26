package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {
    Comment findByBookId(Integer id);
    Comment findByUserId(Integer id);
    void add(Comment comment);
}
