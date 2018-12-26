package com.jxky.bgxs;

import com.jxky.bgxs.dao.RedisDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisDAO redisDAO;

    @Test
    public void redisTest(){
//        redisDAO.setKey("xc","xuechao");
//        System.out.println(redisDAO.getValue("xc"));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dates = "2018-12-14";
//        String date = "Tue Nov 13 2018";
//        Date parse = sdf.parse(dates);
//        System.out.println(parse);

    }
}
