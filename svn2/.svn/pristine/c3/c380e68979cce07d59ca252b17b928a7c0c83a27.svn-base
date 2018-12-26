package com.jxky.bgxs.service.wjt;

import com.jxky.bgxs.dao.MessageDAO;
import com.jxky.bgxs.entity.Message;
import com.jxky.bgxs.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageDAO messageDAO;
    public List<Message> findByAcceptUserId(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        List<Message> acceptMessageList = messageDAO.findByAcceptUserId(user.getId());
        return acceptMessageList;
    }
    public void insert(Message message){
        messageDAO.insert(message);
    }
}
