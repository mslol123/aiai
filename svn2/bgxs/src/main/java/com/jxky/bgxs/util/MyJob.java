package com.jxky.bgxs.util;

import com.jxky.bgxs.dao.ChapterDAO;
import com.jxky.bgxs.dao.RedisDAO;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.service.wt.ChapterService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyJob implements Job {
//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private RedisDAO redisDAO;
    @Resource
    private ChapterDAO chapterDAO;

//    public String content;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getKey().toString().substring(8);
        System.out.println(jobName+"定时任务开启..");
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String ids = jobDataMap.getString("id");

        System.out.println(jobName+"定时任务结束..");
        System.out.println("dsrw");
//        String ids = redisDAO.getValue("id");
        Integer id = Integer.parseInt(ids);
        System.out.println(id+"---");
        Chapter chapter = chapterDAO.findById(id);
        chapter.setChapterReleaseMode("1");
        System.out.println(chapter);
        chapterDAO.update(chapter);
    }

}
