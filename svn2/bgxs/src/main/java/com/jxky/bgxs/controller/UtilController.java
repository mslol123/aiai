package com.jxky.bgxs.controller;

import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.util.CommonHelper;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class UtilController {
    @Autowired
    private CommonHelper commonHelper;
    @Autowired
    private BookMessageService bookMessageService;
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/test")
    public String test(Model model){
        String chapter = "1/137";
        String[] strings = chapter.split("/");
        String path = strings[1]+".txt";
        String name = strings[0]+"/";
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "/test";
    }

    @RequestMapping("/show/{Path}")
    public void show(@PathVariable("Path") String imgPath, @Param("name") String name, HttpServletResponse response) {
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
