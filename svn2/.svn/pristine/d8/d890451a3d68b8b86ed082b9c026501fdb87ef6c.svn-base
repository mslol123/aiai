package com.jxky.bgxs.service.zq;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class SeckillService {

    @Resource
    private RedisTemplate<String,Integer> redisTemplate;

    public void addRedis(String bookname,Integer num){
        redisTemplate.boundValueOps(bookname).set(num);
        System.out.println(redisTemplate.boundValueOps(bookname).get());
    }
}
