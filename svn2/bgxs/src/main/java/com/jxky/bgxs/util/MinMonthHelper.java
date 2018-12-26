package com.jxky.bgxs.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class MinMonthHelper {
    public Date getMinMonthDate(Date date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public Date getLastFrom(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
// 不加下面2行，就是取当前时间前一个月的第一天及最后一天
        cal.setTimeInMillis( System.currentTimeMillis());
        int month = cal.get(Calendar.MONTH);
        cal.set(Calendar.YEAR,2018);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
//        cal.add(Calendar.DAY_OF_MONTH, -1);
//        Date lastDate = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDate = cal.getTime();
//        System.out.println(sdf.format(lastDate));
//        System.out.println(sdf.format(firstDate));
        return firstDate;
    }

    public Date getLastTo(){
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
//        cal.set(Calendar.DAY_OF_MONTH, 1);
//        Date firstDate = cal.getTime();
//        System.out.println(sdf.format(lastDate));
//        System.out.println(sdf.format(firstDate));
        return lastDate;
    }
}
