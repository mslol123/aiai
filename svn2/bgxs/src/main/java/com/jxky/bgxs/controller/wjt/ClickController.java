package com.jxky.bgxs.controller.wjt;

import com.jxky.bgxs.entity.LoginResult;
import com.jxky.bgxs.service.wjt.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/click")
public class ClickController {
    @Autowired
    private ClickService clickService;
    @RequestMapping("/add")
    @ResponseBody
    public LoginResult addClick(int bookId ,int num){
        LoginResult result = clickService.addClick(bookId ,num);
        return result;
    }
}
