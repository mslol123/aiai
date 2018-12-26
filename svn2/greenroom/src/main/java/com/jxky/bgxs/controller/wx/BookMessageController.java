package com.jxky.bgxs.controller.wx;

import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.BookType;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.wx.BookTypeService;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bookMessage")
public class BookMessageController {
    @Resource
    private BookMessageService bookMessageService;
    @Resource
    private BookTypeService bookTypeService;

    @RequestMapping("/preUpdate/{id}")
    public String updateBook(@PathVariable("id") Integer id, Model model){
        BookMessage message = bookMessageService.findById(id);
        List<BookType> bookTypes = bookTypeService.findAll();
        model.addAttribute("bookTypes",bookTypes);
        model.addAttribute("message",message);
        return "author/bianjizuoping";
    }

    @RequestMapping("/addChapter/{id}")
    public String addChapter(@PathVariable("id")Integer id,Model model){
        BookMessage bookMessage = bookMessageService.findById(id);
        model.addAttribute("bookMessage",bookMessage);
        return "author/zhangjie";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        bookMessageService.delete(id);
        return "redirect:/author/bookMessage/list";
    }

    @RequestMapping("/update")
    public String preUpdate(BookMessage bookMessage){
        bookMessageService.updateBookMessage(bookMessage);

        return "redirect:/author/bookMessage/list";

    }

    @RequestMapping("/preAdd")
    public String preAdd(Model model){
        List<BookType> bookTypes = bookTypeService.findAll();
        model.addAttribute("bookTypes",bookTypes);

        return "author/x";
    }

    @RequestMapping("/list/{id}")
    public String findAllByAuthorId(@PathVariable("id") Integer id,Model model){
        List<BookMessage> list = bookMessageService.findAllByAuthorId(id);
        model.addAttribute("list",list);
        model.addAttribute("size",list.size());
        return "author/zuozhe";
    }



    @RequestMapping("/add")
    public String add(MultipartFile file, BookMessage bookMessage){
        try {
            if (!file.isEmpty()) {

                byte[] bytes = file.getBytes();
                String filename = file.getOriginalFilename();
                bookMessage.setBookImage(filename);
                bookMessage.setBookCreattime(new Date());
                bookMessage.setBookExamineStatus("待审核");
                bookMessage.setBookNum("0");
                bookMessage.setBookIsEnd("未完结");
//                FileOutputStream fileOutputStream = new FileOutputStream("E:/apache/" + filename);
//                fileOutputStream.write(bytes);
//                fileOutputStream.flush();
//                fileOutputStream.close();
                //使用FTP进行图片远程上传
                try{
                    FTPClient ftp=new FTPClient();
                    //FTP服务器的IP和端口
                    ftp.connect("192.168.54.5",21);
                    //匿名用户必须使用anonymous登录，密码是邮箱
                    boolean login=ftp.login("anonymous","1756229479@qq.com");
                    System.out.println(login);

                    //获取ftp是否响应的状态吗
                    int replyCode=ftp.getReplyCode();
                    //判断ftp是否正确的回执（一般情况下此处响应失败是因为登录失败了）
                    if(!FTPReply.isPositiveCompletion(replyCode)){
                        System.out.println("FTP响应失败");
                        return "fail";
                    }
                    //如果登录成功，开始上传
                    //配置上传文件的类型（BINARY_FILE_TYPE二进制文件，可以上传所有文件）
                    ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
                    //创建一个文件夹，如果文件夹已存在则不会重新创建
                    ftp.makeDirectory("images");
                    //将ftp要操作的文件夹指定为images（将图片上传到iamges文件夹下）
                    ftp.changeWorkingDirectory("images");
//                    FileInputStream fileInputStream=new FileInputStream("D:\\javaee\\1804\\课堂笔记\\images\\jmeter-http001.png");


                    InputStream inputStream = file.getInputStream();
                    //将图片通过ftp写入独立的图片服务器
                    ftp.storeFile(filename,inputStream);
                    //ftpClient.dele(filename);
                    //退出登录，释放资源
                    ftp.logout();
                }catch(IOException e){
                    e.printStackTrace();
                }
                bookMessageService.insert(bookMessage);
                return "author/zhangjie";
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }




}

