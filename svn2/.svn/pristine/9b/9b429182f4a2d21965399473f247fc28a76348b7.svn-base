package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO {
    List<Comment> findByBookId(Integer id);
    List<Comment> findByUserId(Integer id);
    void add(Comment comment);
}
