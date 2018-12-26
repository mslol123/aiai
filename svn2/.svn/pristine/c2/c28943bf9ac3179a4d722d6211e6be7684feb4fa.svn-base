package com.jxky.bgxs.controller.gzx;

import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/green")
public class FileListController {
    @Autowired
    private BookMessageService bookMessageService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("filelist")
    public String filelist(Model model){
        List<Chapter> chapterList=chapterService.findChapterByStatus("举报");
        model.addAttribute("chapterList",chapterList);
        return "greenroom/filelist";
    }

    @RequestMapping("test/{id}")
    public String test(@PathVariable("id")Integer id, Model model){
        Chapter chapter = chapterService.findById(id);
        String array[]=chapter.getChapterPath().split("/");
        String path=array[1] + ".txt";
        String name = array[0] + "/";
        model.addAttribute("name",name);
        model.addAttribute("path",path);
        model.addAttribute("chapter",chapter);
        return "test";
    }

    @RequestMapping("detail/{id}")
    public String fileDetail(@PathVariable("id")Integer id, Model model){
        Chapter chapter = chapterService.findById(id);
        model.addAttribute("chapter",chapter);
        return "greenroom/detail";
    }

    @RequestMapping("shenpi/{id}")
    public String shenpi(@PathVariable("id")Integer id,Model model){
        Chapter chapter=chapterService.findById(id);
        String[] array=chapter.getChapterPath().split("/");
        try{
            FTPClient ftpClient=new FTPClient();
            ftpClient.connect("192.168.54.5",21);
            ftpClient.login("anonymous","1061012815@qq.com");
            ftpClient.makeDirectory("images"+"\\"+chapter.getChapterBookId());
//                    ftpClient.makeDirectory("images");
//                    ftpClient.changeWorkingDirectory("images");
            ftpClient.changeWorkingDirectory("images"+"\\"+chapter.getChapterBookId());
//                    String name= ConvertHelper.convertStringToUTF8(bookMessage.getBookName()+"/"+chapter.getChapterName());
            UTF8OutputStreamWriter ow=new UTF8OutputStreamWriter(ftpClient.storeFileStream(array[1]+".txt"));
//                    BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(ftpClient.storeFileStream(chapter.getChapterName()+".txt"),"utf-8"));
//                    ow.flush();
//            System.out.println("查看内容："+content);
            ow.write("涉及违禁词汇，已屏蔽");
//            System.out.println("OK");
            ow.flush();
            ow.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        chapter.setChapterStatus("");
        chapterService.update(chapter);
        List<Chapter> chapterList=chapterService.findChapterByStatus("举报");
        model.addAttribute("chapterList",chapterList);
        return "greenroom/filelist";
    }

    @RequestMapping("jujue/{id}")
    public String jujue(@PathVariable("id") Integer id ,Model model){
        Chapter chapter=chapterService.findById(id);
        chapter.setChapterStatus("");
        chapterService.update(chapter);
        List<Chapter> chapterList=chapterService.findChapterByStatus("举报");
        model.addAttribute("chapterList",chapterList);
        return "greenroom/filelist";
    }
}
