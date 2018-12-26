package com.jxky.bgxs.controller.gzx;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jxky.bgxs.entity.Admin;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.Notice;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.gzx.AdminService;
import com.jxky.bgxs.service.gzx.NoticeService;
import com.jxky.bgxs.service.wx.BookMessageService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/greenroom")
@SessionAttributes(value = {"admin"})
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private BookMessageService bookMessageService;
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/log")
    public String log(String username, String password, Model model){
        if((adminService.findByusername(username)) != null) {
            if (adminService.findByusername(username)
                    .getPassword().equals(password)) {
                adminService.login(username,password);
//                Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
                model.addAttribute("admin", adminService.findByusername(username));
                Admin admin1 = adminService.findByusername(username);
                admin1.setLogtime(new Date());
                adminService.updatelogtime(admin1);
                return "greenroom/main1";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "greenroom/login";
            }
        }else{
            model.addAttribute("msg", "用户名或密码错误");
            return "greenroom/login";
        }
    }

    @RequestMapping("changepwd")
    public String changepwd(){
        return "greenroom/changepwd";
    }

    @RequestMapping("updatepwd")
    public String changepwd(@SessionAttribute("admin")Admin admin,String oldpwd,String newpwd1,String newpwd2,Model model){
        if(!admin.getPassword().equals(oldpwd)){
            model.addAttribute("msg","原密码不正确");
            return "greenroom/changepwd";
        }else if(!newpwd1.equals(newpwd2)){
            model.addAttribute("msg","两次输入的密码有误");
            return "greenroom/changepwd";
        }else if(oldpwd.equals(newpwd1)){
            model.addAttribute("msg","输入密码没有改变");
            return "greenroom/changepwd";
        }else {
            admin.setPassword(newpwd1);
            adminService.updatepwd(admin);
            return "greenroom/index";
        }
    }


    @RequestMapping("computer")
    public String computer(){
        return "/greenroom/computer";
    }

    @RequestMapping("main")
    public String main1(){
        return "/greenroom/main1";
    }

    @RequestMapping("top")
    public String top(){
        return "/greenroom/top";
    }

    @RequestMapping("left")
    public String left(){
        return "/greenroom/left";
    }

    @RequestMapping("index")
    public String index(@SessionAttribute("admin")Admin admin,Model model){
        Date logtime = admin.getLogtime();
        model.addAttribute("logtime",logtime);
        return "/greenroom/index";
    }

    @RequestMapping("default")
    public String default1(){
        return "/greenroom/default";
    }

    @RequestMapping("error")
    public String erro1(){
        return "/greenroom/error";
    }

    @RequestMapping("filelist")
    public String filelist(){
        return "/greenroom/filelist";
    }

    @RequestMapping("history")
    public String history(){
        return "/greenroom/history";
    }

    @RequestMapping("form")
    public String form(){
        return "/greenroom/form";
    }

    @RequestMapping("imglist")
    public String imglist(){
        return "/greenroom/imglist";
    }

    @RequestMapping("imglist1")
    public String imglist1(){
        return "/greenroom/imglist1";
    }

    @RequestMapping("login")
    public String login(){
        return "greenroom/login";
    }

    @RequestMapping("imgtable")
    public String imgtable(){

        return "/greenroom/imgtable";
    }

    @RequestMapping("right")
    public String right(){
        return "/greenroom/right";
    }

    @RequestMapping("tab")
    public String tab(){
        return "/greenroom/tab";
    }

    @RequestMapping("tools")
    public String tools(){
        return "/greenroom/tools";
    }

    @RequestMapping("/findbook")
    @ResponseBody
    public Integer findbook(String bookname){
        List<BookMessage> books = bookMessageService.checkbook(bookname);
        if(books.size() == 0){
            return 4;
        }else {
            return 5;
        }
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<Notice> find(Integer mattertype) throws ParseException {
        List<Notice> notices = noticeService.findByType(mattertype);
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        for(Notice notice:notices){
//            String format = df.format(notice.getCreatetime());
//            Date date = df.parse(notice.getCreatetime().toString());
//            System.out.println(date);
//            notice.setCreatetime(date);
//        }

        return notices;
    }
}
