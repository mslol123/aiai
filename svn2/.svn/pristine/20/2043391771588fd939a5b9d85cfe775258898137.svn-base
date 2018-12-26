package com.jxky.bgxs.controller.wjt;

import com.alibaba.fastjson.JSON;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.Message;
import com.jxky.bgxs.entity.Notice;
import com.jxky.bgxs.service.gzx.NoticeService;
import com.jxky.bgxs.service.wx.BookMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Date;
import java.util.List;

/**
 * @author: elvin
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private BookMessageService bookMessageService;

    @RequestMapping("/queue")
    @ResponseBody
    public Integer queue(String matter,String bookname,String count){
        try {
            if(matter != null){
                jms.convertAndSend(queue, matter);
                Notice notice = new Notice();
                notice.setMatter(matter);
                notice.setCreatetime(new Date());
                notice.setMattertype(1);
                noticeService.save(notice);
            }
            if(bookname != null){
                String message = "**即将开始一元秒杀活动**       #活动三十秒后开始#" +
                        "      书名：《"+ bookname + "》/数量:1";
//                        + count;
                jms.convertAndSend(queue, message);
                Notice notice = new Notice();
                notice.setCreatetime(new Date());
                notice.setMatter(message);
                notice.setMattertype(2);
                noticeService.save(notice);
            }

//            jms.convertAndSend(queue, "测试");
            return 1;
        }catch (Exception e){
            return 0;
        }

    }






@JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(Message message){
        message.setMesageTheme("你好");
        message.setMessageContent("Hello Word");
        String jsonString = JSON.toJSONString(message);
        jms.convertAndSend(topic, jsonString);
        return "topic 发送成功";
    }
}
