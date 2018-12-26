package com.jxky.bgxs.controller.wjt;

import com.alibaba.fastjson.JSON;
import com.jxky.bgxs.entity.Message;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

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

    @RequestMapping("/queue")
    @ResponseBody
    public String queue(String bookname,String chaptername){
        String tip = "亲爱的读者，您所关注的书籍"+bookname+"发布了新章节"+chaptername+"上线一睹为快吧！";
            jms.convertAndSend(queue, "tip");
        return "queue 发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        GoEasy goEasy = new GoEasy("BC-58a22e706d3342ecafd6bd784c07d335");
        goEasy.publish("seckill", msg);
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(Message message){

//        message.setSendUser(1);
//        message.setAcceptUser(2);
        message.setMesageTheme("你好");
        message.setMessageContent("Hello Word");
        String jsonString = JSON.toJSONString(message);
        jms.convertAndSend(topic, jsonString);
        return "topic 发送成功";
    }
}
