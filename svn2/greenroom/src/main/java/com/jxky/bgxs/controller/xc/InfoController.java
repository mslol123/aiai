package com.jxky.bgxs.controller.xc;


import com.jxky.bgxs.entity.Info;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.xc.InfoService;
import com.jxky.bgxs.service.zq.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/setting")
public class InfoController {
   @Resource
    private InfoService infoService;
   @Resource
   private UserService userService;

    @RequestMapping("/info")
   public String userInfo(Model model){
       User user =(User) SecurityUtils.getSubject().getPrincipal();
       Info info = infoService.findById(user.getId());
       model.addAttribute("info",info);
       return "setting/userInfo";
   }

    @RequestMapping("/add")
    public String add(Info info, @Param("birth")String birth){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        info.setId(user.getId());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
            info.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(info.getSex().equals("0")){
            info.setSex("男");
        }else if(info.getSex().equals("1")){
            info.setSex("女");
        }
        infoService.upadate(info);
        user.setNickname(info.getNickname());
        userService.update(user);
        return "redirect:/setting/info";
    }

    @RequestMapping("/preupdate")
    public String preupdate(Model model){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        Info info = infoService.findById(user.getId());
        if(info.getImage()!=null){
        model.addAttribute("image",info.getImage());}
        return "setting/userAvatar";
    }


    @RequestMapping("/update")
    public String update(MultipartFile file){
        Info info=new Info();
        if(file!=null||file.getSize()>0){
            info.setImage(file.getOriginalFilename());
        }
        infoService.insert(info);
        return "redirect:/preupdate";
    }
}
