package com.jxky.bgxs.controller.wjt;

import com.jxky.bgxs.entity.Message;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.wjt.MessageService;
import com.jxky.bgxs.service.zq.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @RequestMapping("/notice")
    public String notice(Model model){
        List<Message> acceptMessageList = messageService.findByAcceptUserId();
        model.addAttribute("acceptMessageList",acceptMessageList);
        return "/user/msgIn";
    }
    @RequestMapping("/send")
    public String send(){
        return "/user/msgSend";
    }
    @RequestMapping("/sendDo")
    public String sendDo(Message message){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User acceptUser = userService.findByNickname(message.getAcceptUser().getNickname());
        if(acceptUser == null){
            return "/user/msgSend";
        }
        message.setMessageCreateTime(new Date());
        message.setSendUser(user);
        message.setAcceptUser(acceptUser);
        messageService.insert(message);
        return "/user/msgSend";
    }
}
