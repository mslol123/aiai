package com.jxky.bgxs.controller.xc;

import com.jxky.bgxs.entity.Account;
import com.jxky.bgxs.entity.Consume;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.xc.AccountService;
import com.jxky.bgxs.service.xc.ConsumeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/billing")
@SessionAttributes(value = {"account"})
public class AccountController {

    @Resource
    private AccountService accountService;
    @Resource
    private ConsumeService consumeService;

    @RequestMapping("/account")
    public String account(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Account account = accountService.findByUserId(user.getId());
        model.addAttribute("account",account);
        String tel=user.getTel().substring(0,3)+"****"+user.getTel().substring(7,user.getTel().length());
        user.setTel(tel);
        model.addAttribute("user",user);

        return  "/billing/index";
    }
    @RequestMapping("/consume")
    public String consume(Model model, @SessionAttribute("user")User user){
        List<Consume> consumeList = consumeService.findByUserId(user.getId());
        model.addAttribute("consumeList",consumeList);
        return "billing/consumption";
    }

}
