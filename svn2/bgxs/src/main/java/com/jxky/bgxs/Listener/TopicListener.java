package com.jxky.bgxs.Listener;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.JmsListener;

/**
 * @author: elvin
 */
@Component
public class TopicListener {

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }
}
