package com.qiangfeng.oasystem.controller;

import com.qiangfeng.oasystem.entity.ChuChai;
import com.qiangfeng.oasystem.service.ChuChaiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/chuchai")
public class ChuChaiController {
    @Resource
    private ChuChaiService chuChaiService;
    @RequestMapping("/list")
    public String list(Model model){
        //得到历史出差记录
        List<ChuChai> chuChaiList = chuChaiService.findByCurrentUser();
        model.addAttribute("chuChaiList", chuChaiList);
        return "chuchai/list";
    }
    @RequestMapping("/checkList")
    public String checkList(Model model){
        // 得到需要处理的出差申请内容
        List<ChuChai> chuChaiTaskList = chuChaiService.findTaskByCurrentUser();
        model.addAttribute("chuChaiTaskList", chuChaiTaskList);
        return "chuchai/checkList";
    }
    @RequestMapping("/preAdd")
    public String preAdd(){
        return "chuchai/add";
    }
    @RequestMapping("/add")
    public String add(ChuChai chuChai){
        chuChaiService.save(chuChai);
        return "redirect:/chuchai/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        ChuChai chuChai = chuChaiService.findById(id);
        model.addAttribute("chuChai", chuChai);
        System.out.println(chuChai);
        return "chuchai/detail";
    }
    @RequestMapping("/agree")
    public String agree(ChuChai chuChai){
        chuChaiService.chuChaiCheck(true, chuChai);
        return "redirect:/chuchai/list";
    }
    @RequestMapping("/disAgree")
    public String disAgree(ChuChai chuChai){
        chuChaiService.chuChaiCheck(false, chuChai);
        return "redirect:/chuchai/list";
    }

}
