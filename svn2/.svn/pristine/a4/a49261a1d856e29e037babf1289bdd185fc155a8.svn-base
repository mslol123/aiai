package com.qiangfeng.oasystem.controller;

import com.qiangfeng.oasystem.entity.Leave;
import com.qiangfeng.oasystem.service.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Resource
    private LeaveService leaveService;

    @RequestMapping("/list")
    public String list(Model model){
        // 得到历史请假记录
        List<Leave> leaveList = leaveService.findByCurrentUser();
        model.addAttribute("leaveList", leaveList);
        return "leave/list";
    }

    @RequestMapping("/checkList")
    public String checkList(Model model){
        // 得到需要处理的请假内容
        List<Leave> leaveTaskList = leaveService.findTaskByCurrentUser();
        model.addAttribute("leaveTaskList", leaveTaskList);
        return "leave/checkList";
    }

    @RequestMapping("/preAdd")
    public String preAdd(){
        return "/leave/add";
    }

    @RequestMapping("/add")
    public String add(Leave leave){
        leaveService.save(leave);
        return "redirect:/leave/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        Leave leave = leaveService.findById(id);
        model.addAttribute("leave", leave);
        return "/leave/detail";
    }

    @RequestMapping("/agree")
    public String agree(Leave leave){
        leaveService.leaveCheck(true, leave);
        return "redirect:/leave/list";
    }

    @RequestMapping("/disAgree")
    public String disAgree(Leave leave){
        leaveService.leaveCheck(false, leave);
        return "redirect:/leave/list";
    }
}
