package com.jxky.bgxs.util;

import com.jxky.bgxs.service.wt.ChapterService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class MyJob implements Job {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ChapterService chapterService;

//    public String content;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        chapterService.addRedis(content);
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String content = jobDataMap.getString("content");
        String bookName = jobDataMap.getString("bookName");
//        String sc1=(String)jobExecutionContext.getJobDetail().getJobDataMap().get("bookName");
//        String sc2=(String)jobExecutionContext.getJobDetail().getJobDataMap().get("content");
        BoundValueOperations<String,String> boundValueOperations=redisTemplate.boundValueOps(bookName);
        boundValueOperations.set(content);
//        System.out.println(content+".........."+bookName);
    }

}
