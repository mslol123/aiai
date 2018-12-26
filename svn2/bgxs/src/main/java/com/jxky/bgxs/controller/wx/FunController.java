package com.jxky.bgxs.controller.wx;

import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.wx.ModeratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/fun")
public class FunController {
    @Resource
    private ModeratorService moderatorService;
    @Resource
    private ChapterService chapterService;
    @Resource
    private BookMessageService bookMessageService;

//    @RequestMapping("/showModerator")
//    public String showModerator(Model model){
//        Integer id = 1;
//        List<Moderator> all = moderatorService.findAllBookId(id);
//
//        return "author/shuping";
//    }

    @RequestMapping("/draft/{id}")
    public String draft(@PathVariable("id")Integer id, Model model){
        List<Chapter> chapterList = chapterService.findChapterByBookId(id);
        List<Chapter> quartzs = chapterService.findQuartzChapter(id);
        if (null!=chapterList){
            model.addAttribute("list",chapterList);
        }
        if (null!=quartzs){
            model.addAttribute("chapters",quartzs);
        }
        return "author/caogao";
    }

    @RequestMapping("/list/{id}")
    public String list(@PathVariable("id")Integer id,Model model){
        List<BookMessage> messages = bookMessageService.findRefuseById(id);
        model.addAttribute("messages",messages);
        System.out.println(messages.size());
        return "author/message2";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        try {
            bookMessageService.updateWatch(id);
            return "1";
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    @ResponseBody
    @RequestMapping("/deleteChapter/{id}")
    public String deleteChapter(@PathVariable("id") Integer id) {
        chapterService.delete(id);
        return null;
    }

    @RequestMapping("/fuli")
    public String fuli(){
        return "author/fuli";
    }

}

