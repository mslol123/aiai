package com.jxky.bgxs.service.wx;

import com.jxky.bgxs.dao.CommentDAO;
import com.jxky.bgxs.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Resource
    private CommentDAO commentDAO;

    public List<Comment> findByBookId(Integer id){
        return commentDAO.findByBookId(id);
    }

    public List<Comment> findByUserId(Integer id){
        return commentDAO.findByUserId(id);
    }

    public void add(Comment comment){
        commentDAO.add(comment);
    }
}
