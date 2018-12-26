package com.jxky.bgxs.controller.xc;

import com.jxky.bgxs.entity.Account;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.xc.AccountService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/biling")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account")
    public String account(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Account account = accountService.findByUserId(user.getId());
        model.addAttribute("account",account);
        return  "index";
    }
}
