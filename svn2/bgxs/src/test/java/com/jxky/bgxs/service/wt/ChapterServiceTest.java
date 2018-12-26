package com.jxky.bgxs.service.wt;

import com.jxky.bgxs.dao.RedisDAO;
import com.jxky.bgxs.util.MinMonthHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.jxky.bgxs.dao")
public class ChapterServiceTest {
    @Resource
    private ChapterService chapterService;
    @Resource
    private MinMonthHelper minMonthHelper;
    @Resource
    private RedisDAO redisDAO;
    @Test
    public void findAllChapter() throws Exception {
        for (int i=0;i<12;i++){
            Integer count = chapterService.findCountByDate(i, minMonthHelper.getMinMonthDate(new Date()));
            System.out.println(minMonthHelper.getMinMonthDate(new Date()));
            System.out.println(count);
        }

    }
    @Test
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_MONTH, calendar
//                .getActualMinimum(Calendar.DAY_OF_MONTH));
//        Date date = calendar.getTime();
//        String format = sdf.format(date);
//        System.out.println(format);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date strDateFrom = calendar.getTime();
        System.out.println(sdf.format(strDateFrom));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date strDateTo = calendar.getTime();
        System.out.println(sdf.format(strDateTo));
    }

    @Test
    public void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
// 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        cal.setTimeInMillis( System.currentTimeMillis());
        int month = cal.get(Calendar.MONTH);
        cal.set(Calendar.YEAR,2018);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDate = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();
        System.out.println(sdf.format(lastDate));
        System.out.println(sdf.format(firstDate));
    }

    @Test
    public void test3(){
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis( System.currentTimeMillis());
//        int month = cal.get(Calendar.MONTH) + 1; // 因为月是从0开始算起的，所以加个1
//        System.out.println(month);
        String value = redisDAO.getValue("36");
        System.out.println(value);
    }


}