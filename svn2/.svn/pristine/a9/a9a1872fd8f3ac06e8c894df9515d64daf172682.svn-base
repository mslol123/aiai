package com.jxky.bgxs.service.gzx;


import com.jxky.bgxs.dao.NoticeDAO;
import com.jxky.bgxs.entity.Admin;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.entity.Notice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class NoticeService {
    @Resource
    private NoticeDAO noticeDAO;

    public void save(Notice notice){
        noticeDAO.save(notice);
    }

    public List<Notice> findAllNotice(){
        return noticeDAO.findAllNotice();
    }

    public List<Notice> findByType(Integer mattertype){
        return noticeDAO.findByType(mattertype);
    }
}
