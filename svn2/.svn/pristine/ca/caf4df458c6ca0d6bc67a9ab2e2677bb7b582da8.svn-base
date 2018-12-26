package com.jxky.bgxs.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;


public class TestJob implements Job {

    @Autowired
    private MinMonthHelper monthHelper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getKey().toString().substring(8);
        System.out.println(jobName+"定时任务开启..");
        try {
            System.out.println(monthHelper.getMinMonthDate(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(jobName+"定时任务结束..");
    }

}
