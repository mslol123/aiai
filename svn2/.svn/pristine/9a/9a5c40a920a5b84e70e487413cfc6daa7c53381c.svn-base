package com.jxky.bgxs.controller.wx;

import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.entity.Moderator;
import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.ModeratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/fun")
public class FunController {
    @Resource
    private ModeratorService moderatorService;
    @Resource
    private ChapterService chapterService;

    @RequestMapping("/showModerator")
    public String showModerator(Model model){
        Integer id = 1;
        List<Moderator> all = moderatorService.findAllByAuthorId(id);

        return "author/shuping";
    }

    @RequestMapping("/draft/{id}")
    public String draft(@PathVariable("id")Integer id, Model model){
        List<Chapter> chapterList = chapterService.findChapterByBookId(id);
        if (null!=chapterList){
            model.addAttribute("list",chapterList);
        }
        return "author/caogao";
    }

}

