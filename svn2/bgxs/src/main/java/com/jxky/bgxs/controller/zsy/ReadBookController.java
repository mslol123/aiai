package com.jxky.bgxs.controller.zsy;

import com.jxky.bgxs.entity.*;
import com.jxky.bgxs.service.gz.BookDataService;
import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.wx.CommentService;
import com.jxky.bgxs.service.xc.InfoService;
import com.jxky.bgxs.service.zsy.LatelyreadService;
import com.jxky.bgxs.util.CommonHelper;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
public class ReadBookController {

    @Resource
    private BookMessageService bookMessageService;
    @Resource
    private BookDataService bookDataService;
    @Resource
    private ChapterService chapterService;
    @Resource
    private InfoService infoService;
    @Resource
    private CommonHelper commonHelper;
    @Resource
    private LatelyreadService latelyreadService;


    @Autowired
    private CommentService commentService;

    /**
     * author:zsy
     * 测试用，通过访问url：localhost：8080/book/detail来跳转到书籍详情用
     * 根据选择的书籍id查询对应的书籍信息到详情页面
     */
    @RequestMapping("/book/detail")
    public String detail(Integer id, Model model){
        BookMessage bookMessage = bookMessageService.findById(id);
        BookData bookData = bookDataService.findByBookId(id);
        List<Chapter> chapterList = chapterService.findAllChapterByBookId(id);
        Chapter firstChapter = chapterList.get(0);
        if(chapterList.size()==0){
            Chapter lastChapter =chapterList.get(0);
            model.addAttribute("lastChapter",lastChapter);
        }else{
            Chapter lastChapter = chapterList.get(chapterList.size() - 1);
            model.addAttribute("lastChapter",lastChapter);
        }
        model.addAttribute("firstChapter",firstChapter);
        model.addAttribute("bookMessage",bookMessage);
        model.addAttribute("bookData",bookData);
        List<Comment> commentList = commentService.findByBookId(id);
        for (Comment comment : commentList) {
            Info info = infoService.findById(comment.getUserId());
            comment.setImage(info.getImage());
            comment.setName(info.getNickname());
        }
        model.addAttribute("commentList",commentList);
        return "books/book";
    }

    /**
     * author:zsy
     * 根据bookId查询书籍的章节目录
     */
    @RequestMapping("/book/showChapter")
    public String showChapterByBookId(Integer id,Model model){
        Integer bookId = id;
        List<Chapter> chapterList = chapterService.findAllChapterByBookId(bookId);
        //获取当前最新章节
        Chapter lastChapter = chapterList.get(chapterList.size() - 1);
        //获取当前登录的用户
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        //判断当前登录的用户是否存在最近阅读该书籍
        //判断当前用户是否登录
        if(currentUser!=null){
            //查询当前用户最近一次阅读章节
            Integer userId = currentUser.getId();
            Info chapterByUserId = infoService.findLasterChapterByUserId(userId,bookId);
            //如果当前的用户没有阅读过该书籍，则页面最近一次阅读显示第一章
            if(chapterByUserId == null || chapterByUserId.equals("")){
                chapterByUserId = new Info();
                chapterByUserId.setId(currentUser.getId());
                chapterByUserId.setChapter(chapterList.get(0));
            }
            model.addAttribute("chapterByUserId",chapterByUserId);
        }else{
            Info chapterByUserId=new Info();
            chapterByUserId.setChapter(chapterList.get(0));
            model.addAttribute("chapterByUserId",chapterByUserId);
        }
        BookMessage bookMessage = bookMessageService.findById(bookId);
        //最近更新的章节显示
        model.addAttribute("lastChapter",lastChapter);
        //书籍信息
        model.addAttribute("bookMessage",bookMessage);
        //章节目录
        model.addAttribute("chapterList",chapterList);
        return "books/showchapter";
    }

    /**
     * author:zsy
     * 根据点击的章节id，然后进行单章阅读
     * @param id 为章节id
     *
     */
    @RequestMapping("/readChapter")
    public String readChapter(@Param("id")Integer id, Model model){
        //根据章节id查询对应的章节信息
        Chapter readChapter = chapterService.findById(id);
        User currentUser = (User)SecurityUtils.getSubject().getPrincipal();
        //判断是否登录用户，如果有登录用户，再阅读章节时，添加最近阅读
        if(currentUser!=null){
            Integer userId = currentUser.getId();
            Integer chapterId = readChapter.getChapterId();
            Integer bookId = readChapter.getChapterBookId();
            latelyreadService.latelyRead(userId,chapterId,bookId);
        }
        //得到章节的路径
        String chapterPath = readChapter.getChapterPath();
        String[] strings = chapterPath.split("/");
        String path = strings[1]+".txt";
        String name = strings[0]+"/";
        model.addAttribute("readChapter",readChapter);
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "books/chapter";
    }
    /**
     * 全文阅读
     * */
    @RequestMapping("/readAllChapter")
    public String readAllChapter(@Param("id")Integer id, Model model){
        //根据章节id查询对应的章节信息
        Chapter readChapter = chapterService.findById(id);
        //得到章节的路径
        String chapterPath = readChapter.getChapterPath();
        String[] strings = chapterPath.split("/");
        String path = strings[1]+".txt";
        String name = strings[0]+"/";
        model.addAttribute("readChapter",readChapter);
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "books/totalChapter";
    }
    /**
     * 阅读上一章
     * */
    @RequestMapping("/lastChapter")
    public String lastChapter(@Param("id")Integer id, Model model){
        //根据章节id查询对应的章节信息
        Integer lastId = id-1;
        Chapter readChapter = chapterService.findById(lastId);
        //得到章节的路径
        String chapterPath = readChapter.getChapterPath();
        String[] strings = chapterPath.split("/");
        String path = strings[1]+".txt";
        String name = strings[0]+"/";
        model.addAttribute("readChapter",readChapter);
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "books/chapter";
    }

    /**
     * 阅读下一章
     * */
    @RequestMapping("/nextChapter")
    public String nextChapter(@Param("id")Integer id, Model model){
        //根据章节id查询对应的章节信息
        System.out.println("id========="+id);
        Integer nextId =id+1;
        Chapter readChapter = chapterService.findById(nextId);
        //得到章节的路径
        String chapterPath = readChapter.getChapterPath();
        String[] strings = chapterPath.split("/");
        String path = strings[1]+".txt";
        String name = strings[0]+"/";
        model.addAttribute("readChapter",readChapter);
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "books/chapter";
    }

    /**
     * 提供阅读小说文本的接口，返回小说文本
     * */
    @RequestMapping("/read")
    @ResponseBody
    public void read(@Param("imgPath")String imgPath, @Param("name") String name, HttpServletResponse response) {
        String path = "";
        if(name == null || name.equals("")){
            path = imgPath;
        }else {
            path = name+ imgPath;
        }
        OutputStream outputStream = null;
        try {
            FTPClient ftp=new FTPClient();
            //FTP服务器的IP和端口
            ftp.connect("120.79.194.211",21);
            //匿名用户必须使用anonymous登录，密码是邮箱
            boolean login=ftp.login("wx","wx1234");
            System.out.println(login);
            ftp.changeWorkingDirectory("images");
            ftp.setBufferSize(1024);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            InputStream inputStream = ftp.retrieveFileStream(path);
            outputStream = response.getOutputStream();
            byte[] b = new byte[1024*1024];
            int len = 0;
            while ((len = inputStream.read(b)) > -1) {
                outputStream.write(b, 0, len);
                outputStream.flush();
            }
            inputStream.close();
            ftp.completePendingCommand();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
