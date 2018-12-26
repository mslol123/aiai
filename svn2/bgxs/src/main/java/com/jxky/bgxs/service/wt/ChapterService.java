package com.jxky.bgxs.service.wt;

import com.jxky.bgxs.dao.BookMessageDAO;
import com.jxky.bgxs.dao.ChapterDAO;
import com.jxky.bgxs.dao.RedisDAO;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.Chapter;
import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;
import org.apache.commons.net.ftp.FTPClient;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
    @Autowired
    private Scheduler scheduler;

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

    public void update(Chapter chapter,String content){
        BookMessage bookMessage=bookMessageDAO.findById(chapter.getChapterBookId());
        chapter.setChapterWords(content.trim().length());
        if(content.contains("黄")||content.contains("赌")||content.contains("毒")||content.contains("王兴")) {
            chapter.setChapterStatus("举报");
        }else {
            chapter.setChapterStatus("待审核");
        }
        chapter.setChapterStatus("待审核");
        chapterDAO.update(chapter);
        try {
            if (!content.isEmpty()) {
                try{
                    FTPClient ftpClient=new FTPClient();
                    ftpClient.connect("120.79.194.211",21);
                    ftpClient.login("wx","wx1234");
                    ftpClient.makeDirectory("images");
                    ftpClient.changeWorkingDirectory("images");
                    ftpClient.makeDirectory(bookMessage.getBookId()+"");
                    ftpClient.changeWorkingDirectory(bookMessage.getBookId()+"");
//                    String name= ConvertHelper.convertStringToUTF8(bookMessage.getBookName()+"/"+chapter.getChapterName());
                    UTF8OutputStreamWriter ow=new UTF8OutputStreamWriter(ftpClient.storeFileStream(chapter.getChapterId()+".txt"));
//                    BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(ftpClient.storeFileStream(chapter.getChapterName()+".txt"),"utf-8"));
//                    ow.flush();
                    System.out.println(chapter.getChapterId()+".txt");
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
            if (chapter.getChapterReleaseMode()!=null&&chapter.getChapterReleaseMode().equals("0")){
                list.add(chapter);
            }
        }
        return list;
    }
    /**
     * author zsy  根据BOOK ID 查询对应的所有章节
     * */
    public List<Chapter> findAllChapterByBookId(Integer id){
        List<Chapter> chapterList = chapterDAO.findChapterByBookId(id);
        List<Chapter> list = new ArrayList<>();
        for (Chapter chapter:chapterList){
            if (chapter.getChapterReleaseMode()!=null&&chapter.getChapterReleaseMode().equals("1")){
                list.add(chapter);
            }
        }
        return list;
    }

    public List<Chapter> findChapterBybId(Integer id){
        List<Chapter> chapterList = chapterDAO.findChapterByBookId(id);
        List<Chapter> list = new ArrayList<>();
        for (Chapter chapter:chapterList){
            if (chapter.getChapterReleaseMode()!=null&&chapter.getChapterReleaseMode().equals("1")){
                list.add(chapter);
            }
        }
        return list;
    }

    public List<Chapter> findQuartzChapter(Integer id){
        List<Chapter> chapterList = chapterDAO.findChapterByBookId(id);
        List<Chapter> list = new ArrayList<>();
        for (Chapter chapter:chapterList){
            if (chapter.getChapterReleaseMode()!=null&&chapter.getChapterReleaseMode().equals("2")){
                list.add(chapter);
            }
        }
        return list;
    }

    public String getPath(Chapter chapter){
        BookMessage bookMessage=bookMessageDAO.findById(chapter.getChapterBookId());
        int num=chapterDAO.findAllChapter().get(chapterDAO.findAllChapter().size()-1).getChapterId();
        String path = bookMessage.getBookId()+"/"+num;
        return path;
    }


    public void insert(Chapter chapter,String content){
        BookMessage bookMessage=bookMessageDAO.findById(chapter.getChapterBookId());
        int num=chapterDAO.findAllChapter().get(chapterDAO.findAllChapter().size()-1).getChapterId();
        int num1=num+1;
        chapter.setChapterPath(bookMessage.getBookId()+"/"+num1);
        chapter.setChapterCreatetime(new Date());
//        chapter.setPublishTime(null);
        chapter.setChapterWords(content.trim().length());
        System.out.println(bookMessage.getBookNum());
        if(content.contains("黄")||content.contains("赌")||content.contains("毒")||content.contains("王兴")) {
            chapter.setChapterStatus("举报");
        }else {
            chapter.setChapterStatus("待审核");
        }
        chapterDAO.insert(chapter);
        try {
            if (!content.isEmpty()) {
                try{
                    FTPClient ftpClient=new FTPClient();
                    ftpClient.connect("120.79.194.211",21);
                    ftpClient.login("wx","wx1234");
//                    ftpClient.makeDirectory("images"+"\\"+bookMessage.getBookId());
                    ftpClient.makeDirectory("images");
                    ftpClient.changeWorkingDirectory("images");
                    ftpClient.makeDirectory(bookMessage.getBookId()+"");
                    ftpClient.changeWorkingDirectory(bookMessage.getBookId()+"");
//                    ftpClient.changeWorkingDirectory("images"+"\\"+bookMessage.getBookId());
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

//    public void quarzToRedis(String chapterPath,Date date){
//        System.out.println(date);
//        Chapter chapter = chapterDAO.findChapterByPath(chapterPath);
//        try {
////            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
////            //任务执行者
////            Scheduler scheduler = stdSchedulerFactory.getScheduler();
//            //任务（配置待执行的job，withIdentity给job指定一个ID）
//            System.out.println(chapter.getChapterId());
//            JobBuilder name1 = JobBuilder.newJob().ofType(MyJob.class).withIdentity("name1")
//                    .usingJobData("id",chapter.getChapterId());
////            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////            Date myDate2 = dateFormat2.parse("2018-11-4 15:27:09");
//            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
//                    .withIdentity(chapter.getChapterName(), "group1")
////                    .startAt(date)
//                    .withSchedule(
//                            SimpleScheduleBuilder.simpleSchedule()
//                                    .withIntervalInSeconds(3))//每300秒执行一次
////                                    .withRepeatCount(1))
//                    .build();
//            scheduler.scheduleJob(name1.build(), simpleTrigger);
////            scheduler.getContext().put("content",content);
//            System.out.println(chapterPath);
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public Chapter findById(Integer id){
        return chapterDAO.findById(id);
    }

}

