package com.jxky.bgxs.controller.gz;

import com.jxky.bgxs.entity.BookData;
import com.jxky.bgxs.service.gz.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookData")
public class BookDataController {

    @Autowired
    private BookDataService bookDataService;

    public String findByBookClick(Model model){
        List<BookData> bookDataList=bookDataService.findByBookClick();
        model.addAttribute("bookDataList",bookDataList);
        return "rank";
    }

}
