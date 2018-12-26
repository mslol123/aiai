package com.qiangfeng.oasystem.controller;

import com.qiangfeng.oasystem.entity.Jiaban;
import com.qiangfeng.oasystem.service.JiabanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/jiaban")
public class JiabanController {
    @Resource
    private JiabanService jiabanService;

    @RequestMapping("/list")
    public String list(Model model){
        // 得到历史请假记录
        List<Jiaban> jiabanList = jiabanService.findByCurrentUser();
        model.addAttribute("jiabanList", jiabanList);
        return "jiaban/list";
    }

    @RequestMapping("/checkList")
    public String checkList(Model model){
        // 得到需要处理的请假内容
        List<Jiaban> jiabanTaskList = jiabanService.findTaskByCurrentUser();
        model.addAttribute("jiabanTaskList", jiabanTaskList);
        return "jiaban/checkList";
    }

    @RequestMapping("/preAdd")
    public String preAdd(){
        return "/jiaban/add";
    }

    @RequestMapping("/add")
    public String add(Jiaban jiaban){
        jiabanService.save(jiaban);
        return "redirect:/jiaban/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        Jiaban jiaban = jiabanService.findById(id);
        model.addAttribute("jiaban", jiaban);
        return "/jiaban/detail";
    }

    @RequestMapping("/agree")
    public String agree(Jiaban jiaban){
        jiabanService.jiabanCheck(true, jiaban);
        return "redirect:/jiaban/list";
    }

    @RequestMapping("/disAgree")
    public String disAgree(Jiaban jiaban){
        jiabanService.jiabanCheck(false, jiaban);
        return "redirect:/jiaban/list";
    }
}
