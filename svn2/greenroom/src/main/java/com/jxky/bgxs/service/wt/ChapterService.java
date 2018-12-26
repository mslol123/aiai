package com.jxky.bgxs.service.wt;

import com.jxky.bgxs.dao.BookMessageDAO;
import com.jxky.bgxs.dao.ChapterDAO;
import com.jxky.bgxs.dao.RedisDAO;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.util.MyJob;
import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;
import org.apache.commons.net.ftp.FTPClient;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ChapterService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ChapterDAO chapterDAO;
    @Autowired
    private BookMessageDAO bookMessageDAO;
    @Autowired
    private RedisDAO redisDAO;

    public List<Chapter> findChapterByStatus(String status){
        return chapterDAO.findChapterByStatus(status);
    }

    public void deleteChapterStatus(Integer id){
        chapterDAO.deleteChapterStatus(id);
    }

    public List<Chapter> findAllChapter(){
        return chapterDAO.findAllChapter();
    }

    public List<Chapter> findChapterNameByBookId(Integer id){
        return chapterDAO.findChapterByBookId(id);
    }

    public void useRedis(String content){
//        String jobName= UUID.randomUUID().toString().replace("-","");
        redisDAO.setKey("lshc",content);
        System.out.println(redisDAO.getValue("lshc"));
    }

    public void update(Chapter chapter){
        chapterDAO.update(chapter);
    }

    public void delete(Integer id){
        chapterDAO.delete(id);
    }

    public List<Chapter> findChapterByDate(Integer id, Date date){
        return chapterDAO.findChapterByDate(id,date);
    }

    public Integer findCountByDate(Integer id, Date date){
        return chapterDAO.findCountByDate(id,date);
    }

    public List<Chapter> findChapterByBookId(Integer id){
        List<Chapter> chapterList = chapterDAO.findChapterByBookId(id);
        List<Chapter> list = new ArrayList<>();
        for (Chapter chapter:chapterList){
            if (chapter.getChapterReleaseMode().equals("0")){
                list.add(chapter);
            }
        }
        return list;
    }

    public void insert(Chapter chapter,String content){
        BookMessage bookMessage=bookMessageDAO.findById(chapter.getChapterBookId());
        int num=chapterDAO.findAllChapter().size();
        int num1=num+1;
        chapter.setChapterPath(bookMessage.getBookId()+"/"+num1);
        chapter.setChapterCreatetime(new Date());
        chapter.setChapterWords(content.trim().length());
        chapter.setChapterStatus("待审核");
        chapterDAO.insert(chapter);
        try {
            if (!content.isEmpty()) {
                try{
                    FTPClient ftpClient=new FTPClient();
                    ftpClient.connect("120.77.145.83",21);
                    ftpClient.login("anonymous","1061012815@qq.com");
                    ftpClient.makeDirectory("images"+"\\"+bookMessage.getBookId());
//                    ftpClient.makeDirectory("images");
//                    ftpClient.changeWorkingDirectory("images");
                    ftpClient.changeWorkingDirectory("images"+"\\"+bookMessage.getBookId());
//                    String name= ConvertHelper.convertStringToUTF8(bookMessage.getBookName()+"/"+chapter.getChapterName());
                    UTF8OutputStreamWriter ow=new UTF8OutputStreamWriter(ftpClient.storeFileStream(chapterDAO.findById(num1).getChapterId()+".txt"));
//                    BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(ftpClient.storeFileStream(chapter.getChapterName()+".txt"),"utf-8"));
//                    ow.flush();
                    System.out.println(chapterDAO.findById(num1).getChapterId()+".txt");
                    System.out.println("查看内容："+content);
                    ow.write(content);
                    System.out.println("OK");
                    ow.flush();
                    ow.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void quarzToRedis(Integer id,String content){
        String bookName=bookMessageDAO.findById(id).getBookName();
        try {
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            //任务执行者
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            //任务（配置待执行的job，withIdentity给job指定一个ID）
            JobBuilder name1 = JobBuilder.newJob().ofType(MyJob.class).withIdentity("name1")
                    .usingJobData("content",content)
                    .usingJobData("bookName",bookName);
            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(bookName, "group1")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(3))//每300秒执行一次
                    .build();
            scheduler.scheduleJob(name1.build(), simpleTrigger);
//            scheduler.getContext().put("content",content);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Chapter findById(Integer id){
        return chapterDAO.findById(id);
    }

}

