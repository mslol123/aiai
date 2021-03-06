package com.jxky.bgxs.service.wt;

import com.jxky.bgxs.dao.ChapterDAO;
import com.jxky.bgxs.dao.RedisDAO;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.service.wx.QuartzManager;
import com.jxky.bgxs.util.MyJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QuartzService {
    @Autowired
    private ChapterDAO chapterDAO;
//    @Autowired
//    private Scheduler scheduler;
    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private RedisDAO redisDAO;

    public void quarzToRedis(String chapterPath,String date){
        System.out.println(date);
        Chapter chapter = chapterDAO.findChapterByPath(chapterPath);
        String id = chapter.getChapterId().toString();

        try {
            System.out.println(chapterPath);
            String jobName = chapterPath;
            String jobGroupName = "group";
            String triggerName = chapterPath;
            String triggerGroupName = "group";
            String time = "*/5 * * * * ?";
            quartzManager.addJob(date,id,jobName,jobGroupName,triggerName,triggerGroupName, MyJob.class,time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
