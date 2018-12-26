package com.jxky.bgxs.controller.wjt;

import com.jxky.bgxs.entity.BookSearch;
import com.jxky.bgxs.service.wjt.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookMessage")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @RequestMapping("/search")
    public String search(String keyword, Model model){
        List<BookSearch> bookMessageList = searchService.findAllSearch(keyword);
        model.addAttribute("bookMessageList",bookMessageList);
        model.addAttribute("keyword",keyword);
        return "/search/search";
    }
}
