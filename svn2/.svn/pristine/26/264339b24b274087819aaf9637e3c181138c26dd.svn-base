package com.jxky.bgxs.controller.wx;

import com.jxky.bgxs.entity.Author;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.BookType;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.wx.BookTypeService;
import com.jxky.bgxs.service.wx.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/house")
//@SessionAttributes(value = {"admin"})
public class HouseController {
    @Resource
    private BookMessageService bookMessageService;
    @Resource
    private BookTypeService bookTypeService;
    @Resource
    private HouseService houseService;

    @RequestMapping("/list")
    public String findNewBook(Model model){
        List<BookMessage> newBook = bookMessageService.findNewBook();
        model.addAttribute("list",newBook);
        return "greenroom/imglist";
    }

    @RequestMapping("/watchBook/{id}")
    public String watchBook(@PathVariable("id") Integer id, Model model){
        BookMessage message = bookMessageService.findById(id);
        List<BookType> bookTypes = bookTypeService.findAll();
//        model.addAttribute("bookTypes",bookTypes);
        model.addAttribute("book",message);
        return "greenroom/x";
    }

    @RequestMapping("/agreen/{id}")
    public String agreen(@PathVariable("id")Integer id){
        BookMessage book = bookMessageService.findById(id);
        book.setBookExamineStatus("审核通过");
        bookMessageService.updateBookMessage(book);
        return "redirect:/house/list";
    }

    @RequestMapping("/disAgreen")
    public String disAgreen(BookMessage book){
//        BookMessage book = bookMessageService.findById(bookMessage.);
        book.setExamineTime(new Date());
//        StringBuilder sb = new StringBuilder();
//        String word = book.getBookWord();
//        sb.append(word);
//        Integer len = word.length();
//        if(len<23){
//        for (int i=0;i<23;i++){
//            sb.append(" ");
//        }

//        }
//        book.setRefuseWord(sb.toString());
        book.setBookExamineStatus("审核未通过");
        bookMessageService.updateBookMessage(book);
        return "redirect:/house/list";
    }

    @RequestMapping("/pay")
    public String pay(Model model){
        List<Author> list = houseService.findPayAuthor();
        model.addAttribute("list",list);
        return "greenroom/right";
    }

    @RequestMapping("/payList/{id}")
    public String payList(Model model,@PathVariable("id")Integer id){
        List<Chapter> chapters = houseService.findAuthorChapter(id);
        model.addAttribute("chapters",chapters);
        model.addAttribute("id",id);
        return "greenroom/right2";
    }
}
