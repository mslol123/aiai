package com.qiangfeng.oasystem.controller;


import com.qiangfeng.oasystem.entity.YongChe;
import com.qiangfeng.oasystem.service.YongCheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/yongche")
public class YongCheController {
    @Resource
    private YongCheService yongCheService;
    @RequestMapping("/list")
    public String list(Model model){
        //得到历史出差记录
        List<YongChe> yongCheList = yongCheService.findByCurrentUser();
        model.addAttribute("yongCheList", yongCheList);
        return "yongche/list";
    }
    @RequestMapping("/checkList")
    public String checkList(Model model){
        // 得到需要处理的出差申请内容
        List<YongChe> yongCheTaskList = yongCheService.findTaskByCurrentUser();
        model.addAttribute("yongCheTaskList", yongCheTaskList);
        return "yongche/checkList";
    }
    @RequestMapping("/preAdd")
    public String preAdd(){
        return "yongche/add";
    }
    @RequestMapping("/add")
    public String add(YongChe yongChe){
        yongCheService.save(yongChe);
        return "redirect:/yongche/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        YongChe yongChe = yongCheService.findById(id);
        model.addAttribute("yongChe", yongChe);
        System.out.println(yongChe);
        return "yongche/detail";
    }
    @RequestMapping("/agree")
    public String agree(YongChe yongChe){
        yongCheService.yongCheCheck(true, yongChe);
        return "redirect:/yongche/list";
    }
    @RequestMapping("/disAgree")
    public String disAgree(YongChe yongChe){
        yongCheService.yongCheCheck(false, yongChe);
        return "redirect:/yongche/list";
    }

}
