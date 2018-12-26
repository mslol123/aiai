package com.jxky.bgxs.controller.zq;

import com.jxky.bgxs.entity.Indent;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.zq.IndentService;
import com.jxky.bgxs.service.zq.SeckillService;
import org.apache.shiro.SecurityUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Resource
    private SeckillService seckillService;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private IndentService indentService;

    private String sb;

    @RequestMapping("indent")
    public String indent(){
        return "fans/bookFansScore";
    }

    @RequestMapping("commodity")
    @ResponseBody
    public String commodity(String content,Integer num){
        String str = content;
        System.out.println(str);
        int s = str.indexOf("《");
        int l = str.indexOf("》");
        sb = str.substring(s+1, l);
        seckillService.addRedis(sb,num);
        return "";
    }

    @RequestMapping("/commodity1")
    public String commodity1(){
        return "seckill/commodity";
    }

    @RequestMapping("/preseckill")
    @ResponseBody
    public String preseckill(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user != null){
            return "000";
        }else {
            return "001";
        }
    }

    @RequestMapping("/seckill")
    public String seckill(String content, Model model){
        model.addAttribute("content",content);
        System.out.println("*******---------*******");
        return "seckill/seckill";
    }

    @RequestMapping("/judge")
    @ResponseBody
    public String judge(){
        List<Object> list = redisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations redisOperations) throws DataAccessException{
                redisOperations.watch(sb);
                Integer num = (Integer) redisOperations.boundValueOps(sb).get();
                redisOperations.multi();
                if (num > 0) {
                    redisOperations.boundValueOps(sb).set(num - 1);
                }
                List list1 = redisOperations.exec();
                System.out.println(list1);
                return list1;
            }
        });
        if(list==null||list.isEmpty()){
            System.out.println("fail");
            return "001";
        }else {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            long time=new Date().getTime();
            Date date=new Date(time);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
            //SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = sdf.format(date);
            //String format1 = sdf1.format(date);
            Indent indent = new Indent();
            indent.setNumber(format);
            indent.setTime(date);
            indent.setName(sb);
            indent.setPrice(1);
            indent.setUserId(user.getId());
            indent.setState("未支付");
            indentService.insert(indent);
            return "000";
        }
    }
}
