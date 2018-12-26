package com.jxky.bgxs.service.zsy;

import com.jxky.bgxs.dao.LatelyReadDAO;
import com.jxky.bgxs.entity.LatelyRead;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LatelyreadService {
    @Resource
    private LatelyReadDAO latelyReadDAO;

    /**
     * 添加或修改最近一次阅读的章节
     * */
    public void  latelyRead(Integer userId,Integer chapterId,Integer bookId){
        //判断用户之前是否阅读过该书籍的章节
        LatelyRead latelyRead = latelyReadDAO.findByUserIdAndBookId(userId, bookId);
        //如果查询为null，添加一条阅读记录
        if (latelyRead==null){
            latelyReadDAO.firstRead(userId,chapterId,bookId);
        }else {
            latelyReadDAO.updateRead(userId,chapterId,bookId);
        }
    }

    /**
     * 根据用户Id 和用户阅读的书籍id
     * 查询最近一次阅读章节
     * */
    public LatelyRead findByUserIdAndBookId(Integer userId,Integer bookId){
        return latelyReadDAO.findByUserIdAndBookId(userId,bookId);
    }

    /**
     * 根据用户id 查询用户阅读过的书籍 及对应的章节id
     * */
    public List<LatelyRead> findAllByUserId(Integer userId){
        return latelyReadDAO.findAllByUserId(userId);
    }
}
