package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDAO {
    void save(Notice notice);
    List<Notice> findAllNotice();
    List<Notice> findByType(Integer mattertype);
}
