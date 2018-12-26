package com.jxky.bgxs.controller.zq;

import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.zq.IndentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/seckillpay")
public class SeckillPayController {
    @Resource
    private IndentService indentService;

    @RequestMapping("/pay")
    public String par (Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("list",indentService.findByUserId(user.getId()));
        return "/fans/bookFansScore";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
