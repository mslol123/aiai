package com.jxky.bgxs.service.xc;

import com.jxky.bgxs.dao.InfoDAO;
import com.jxky.bgxs.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Autowired
    private InfoDAO infoDAO;

    public Info findById(Integer id){
        return infoDAO.findById(id);
    }

    public void insert(Info info){
        infoDAO.insert(info);
    }

    public void upadate(Info info){
        infoDAO.update(info);
    }

    public Info findLasterChapterByUserId(Integer userId,Integer bookId){
        return infoDAO.findLasterChapterByUserId(userId,bookId);
    }
}
