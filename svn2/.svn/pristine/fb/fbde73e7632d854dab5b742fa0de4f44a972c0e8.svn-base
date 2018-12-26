package com.jxky.bgxs.controller.zsy;

import com.jxky.bgxs.entity.BookData;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.service.gz.BookDataService;
import com.jxky.bgxs.service.wx.BookMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/book")
public class ReadBookController {

    @Resource
    private BookMessageService bookMessageService;
    @Resource
    private BookDataService bookDataService;

    /**
     * author:zsy
     * 测试用，通过访问url：localhost：8080/book/detail来跳转到书籍详情用
     */
    @RequestMapping("/detail")
    public String detail(){
        return "books/book";
    }

    /**
    * author:zsy
    * 用户已经登录后，根据选择的书籍id查询对应的书籍信息到详情页面
     * 返回的是书籍的信息
    **/
    @RequestMapping("/bookMessage")
    @ResponseBody
    public BookMessage findBookMessage(Integer id){
        BookMessage bookMessage = bookMessageService.findById(id);
        return bookMessage;
    }
    /**
     * author:zsy
     * 假设用户已经登录后，根据选择的书籍id查询对应的书籍信息到详情页面
     * 返回的是书籍的数据
     **/
    @RequestMapping("/bookData")
    @ResponseBody
    public BookData findBook(Integer id){
        BookData bookData = bookDataService.findByBookId(id);
        return bookData;
    }
}
