package com.jxky.bgxs.controller.wx;

import com.jxky.bgxs.dao.RedisDAO;
import com.jxky.bgxs.entity.BookExcuse;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.Moderator;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.wx.BookExcuseService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.wx.ModeratorService;
import com.jxky.bgxs.service.zq.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/moder")
public class ModerController {
    @Resource
    private ModeratorService moderatorService;
    @Resource
    private UserService userService;
    @Resource
    private BookExcuseService bookExcuseService;
    @Resource
    private RedisDAO redisDAO;
    @Resource
    private BookMessageService bookMessageService;
    @Resource
    private RedisTemplate<Integer,Integer> redisTemplate;

    @RequestMapping("/add")
    public String add(Moderator moderator,String nickname,Model model){
        User user = userService.findByName(nickname);
        List<BookExcuse> excuses = bookExcuseService.findUserByBookId(moderator.getBookId());
        model.addAttribute("excuses",excuses);
        moderator.setUser(user);
        moderator.setCreattime(new Date());
        moderatorService.add(moderator);
        List<Moderator> list = moderatorService.findAllBookId(moderator.getBookId());
        model.addAttribute("list",list);
        model.addAttribute("size",list.size());
        model.addAttribute("id",moderator.getBookId());
        return "author/shuping";
    }
    
    @RequestMapping("/list/{id}")
    public String list(@PathVariable("id") Integer id, Model model){
        List<BookExcuse> excuses = bookExcuseService.findUserByBookId(id);
        List<Moderator> list = moderatorService.findAllBookId(id);
        model.addAttribute("excuses",excuses);
        model.addAttribute("id",id);
        model.addAttribute("list",list);
        model.addAttribute("size",list.size());
        return "author/shuping";
    }

    @RequestMapping("/addExcuse")
    public String addExcuse(BookExcuse bookExcuse,String nickname,Model model){
        User user = userService.findByName(nickname);
        List<Moderator> list = moderatorService.findAllBookId(bookExcuse.getBookId());
        bookExcuse.setUser(user);
        BookMessage book = bookMessageService.findById(bookExcuse.getBookId());
        Integer key = book.getBookId();
        Integer value = user.getId();
            redisTemplate.boundListOps(key).rightPush(value);
        model.addAttribute("list",list);
        model.addAttribute("size",list.size());
        bookExcuse.setCreattime(new Date());
        bookExcuseService.add(bookExcuse);
        List<BookExcuse> excuses = bookExcuseService.findUserByBookId(bookExcuse.getBookId());
        model.addAttribute("excuses",excuses);
        model.addAttribute("id",bookExcuse.getBookId());
        return "author/shuping";
    }

    @RequestMapping("/deleteMod/{id}")
    @ResponseBody
    public String deleteMod(@PathVariable("id")Integer id){
        moderatorService.delete(id);
        return "author/shuping";
    }
    @RequestMapping("/deleteExc/{id}")
    @ResponseBody
    public String deleteExc(@PathVariable("id")Integer id){
        bookExcuseService.delete(id);
        return "author/shuping";
    }

    @RequestMapping("/selectUser/{name}")
    @ResponseBody
    public String selectUser(@PathVariable("name")String name){
        User user = userService.findByName(name);
        if (null == user){
            return "0";
        }else {
            return "1";
        }

//        return null;
    }
}
