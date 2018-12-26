package com.jxky.bgxs.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class TimeHelper {
    public void doTimeRun(Date date){
        try {
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            //任务执行者
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            String name = UUID.randomUUID().toString().replaceAll("-","");
            //任务（配置待执行的job，withIdentity给job指定一个ID）
            JobBuilder name1 = JobBuilder.newJob().ofType(MyJob.class).withIdentity(name);

            //触发器（定时器）//参数：触发器的名称
//            CronTriggerImpl cronTrigger = new CronTriggerImpl("trigger");
            //执行规则
//            cronTrigger.setCronExpression("0/300 * * * * ?");
//            scheduler.scheduleJob(name1.build(),cronTrigger);
//            scheduler.start();
            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time = dateFormat2.format(date);
            Date myDate2 = dateFormat2.parse(time);
            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger3", "group1")
                    .startAt(myDate2)
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
//                                    .withIntervalInSeconds(3)
                                    .withRepeatCount(0))//重复执行的次数，因为加入任务的时候马上执行了，所以不需要重复，否则会多一次。
                    .build();
            scheduler.scheduleJob(name1.build(), simpleTrigger);
            scheduler.start();
//            scheduler.clear();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
