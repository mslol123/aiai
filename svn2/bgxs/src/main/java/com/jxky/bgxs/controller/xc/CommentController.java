package com.jxky.bgxs.controller.xc;

import com.jxky.bgxs.entity.*;
import com.jxky.bgxs.service.gz.BookDataService;
import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.wx.CommentService;
import com.jxky.bgxs.service.xc.InfoService;
import com.jxky.bgxs.service.xc.TicketService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private BookMessageService bookMessageService;
    @Resource
    private BookDataService bookDataService;
    @Resource
    private ChapterService chapterService;
    @Resource
    private InfoService infoService;
    @Resource
    private RedisTemplate<Integer,List<Integer>> redisTemplate;

    @RequestMapping("/list")
    public String findByUserId(Model model, @SessionAttribute("user")User user){
        List<Comment> list = commentService.findByUserId(user.getId());
        for (Comment comment : list) {
            comment.setBookName(bookMessageService.findById(comment.getBookMessageId()).getBookName());
        }
        model.addAttribute("list",list);
        return "user/myDynamic";
    }

    @RequestMapping("/giveNum")
    public String ticket(Model model, @SessionAttribute("user")User user) {
        List<Ticket> ticketList = ticketService.findByUserId(user.getId());
        for (Ticket ticket : ticketList) {
            ticket.setBookName(bookMessageService.findById(ticket.getBookId()).getBookName());
        }
        model.addAttribute("ticketList",ticketList);
        return "user/myOperate";
    }

    @RequestMapping("/ticket")
    public String giveNum(Model model, @SessionAttribute("user")User user) {
        List<Ticket> ticketList = ticketService.findByUserId(user.getId());
        for (Ticket ticket : ticketList) {
            ticket.setBookName(bookMessageService.findById(ticket.getBookId()).getBookName());
        }
        model.addAttribute("ticketList",ticketList);
        return "user/monthVote";
    }

    @RequestMapping("/testadd")
    @ResponseBody
    public String  testadd(@Param("id") Integer id){
       User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null||user.equals("")){
            return "0";
        }else if(redisTemplate.boundListOps(id).range(0, -1).contains(user.getId())){
            return "1";
        }else {
            return "2";
        }
    }

    @RequestMapping("/preadd/{id}")
    public String  preadd(Model model, @PathVariable("id") Integer id){
            BookMessage bookMessage = bookMessageService.findById(id);
            model.addAttribute("bookMessage",bookMessage);
            return "books/comment";
    }

    @RequestMapping("/add")
    public  String add(@SessionAttribute("user")User user,Model model,Comment comment){
        comment.setUserId(user.getId());
        comment.setCreattime(new Date());
        commentService.add(comment);
        BookMessage bookMessage = bookMessageService.findById(comment.getBookMessageId());
        BookData bookData = bookDataService.findByBookId(comment.getBookMessageId());
        List<Chapter> chapterList = chapterService.findChapterByBookId(comment.getBookMessageId());
        Chapter firstChapter = chapterList.get(0);
        Chapter lastChapter = chapterList.get(chapterList.size() - 1);
        model.addAttribute("firstChapter",firstChapter);
        model.addAttribute("lastChapter",lastChapter);
        model.addAttribute("bookMessage",bookMessage);
        model.addAttribute("bookData",bookData);
        List<Comment> commentList = commentService.findByBookId(comment.getBookMessageId());
        for (Comment comment2 : commentList) {
            Info info = infoService.findById(comment.getUserId());
            comment2.setImage(info.getImage());
            comment2.setName(info.getNickname());
        }
        model.addAttribute("commentList",commentList);
        return "books/book";
    }
}
