package com.jxky.bgxs.controller.gz;

import com.jxky.bgxs.entity.BookData;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.entity.PageBean;
import com.jxky.bgxs.service.gz.BookDataService;
import com.jxky.bgxs.service.wt.ChapterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookRank")
public class BookDataController {

    @Autowired
    private BookDataService bookDataService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/book")
    public String findByBookTicket(Model model ,Integer id){
        BookData bookData1=bookDataService.findByBookTicket1();
        List<BookData> bookDataList2=bookDataService.findByBookTicket2();
        List<BookData> bookDataList3=bookDataService.findByBookTicket3();
        List<BookData> bookDataList4=bookDataService.findByBookTicket4();
        model.addAttribute("bookData1",bookData1);
        model.addAttribute("bookDataList2",bookDataList2);
        model.addAttribute("bookDataList3",bookDataList3);
        model.addAttribute("bookDataList4",bookDataList4);
        BookData bookDatas1=bookDataService.findByBookSubscribe1();
        List<BookData> bookDataLists2=bookDataService.findByBookSubscribe2();
        List<BookData> bookDataLists3=bookDataService.findByBookSubscribe3();
        List<BookData> bookDataLists4=bookDataService.findByBookSubscribe4();
        model.addAttribute("bookDatas1",bookDatas1);
        model.addAttribute("bookDataLists2",bookDataLists2);
        model.addAttribute("bookDataLists3",bookDataLists3);
        model.addAttribute("bookDataLists4",bookDataLists4);
        model.addAttribute("bookDatau1",bookDatas1);
        model.addAttribute("bookDataListu2",bookDataLists2);
        model.addAttribute("bookDataListu3",bookDataLists3);
        model.addAttribute("bookDataListu4",bookDataLists4);
        BookData bookDataw1=bookDataService.findByBookClick1();
        List<BookData> bookDataListw2=bookDataService.findByBookClick2();
        List<BookData> bookDataListw3=bookDataService.findByBookClick3();
        List<BookData> bookDataListw4=bookDataService.findByBookClick4();
        model.addAttribute("bookDataw1",bookDataw1);
        model.addAttribute("bookDataListw2",bookDataListw2);
        model.addAttribute("bookDataListw3",bookDataListw3);
        model.addAttribute("bookDataListw4",bookDataListw4);
        BookData bookDataa1=bookDataService.findByBookSales1();
        List<BookData> bookDataLista2=bookDataService.findByBookSales2();
        List<BookData> bookDataLista3=bookDataService.findByBookSales3();
        List<BookData> bookDataLista4=bookDataService.findByBookSales4();
        model.addAttribute("bookDataa1",bookDataa1);
        model.addAttribute("bookDataLista2",bookDataLista2);
        model.addAttribute("bookDataLista3",bookDataLista3);
        model.addAttribute("bookDataLista4",bookDataLista4);
        BookData bookDatac1=bookDataService.findByBookCollection1();
        List<BookData> bookDataListc2=bookDataService.findByBookCollection2();
        List<BookData> bookDataListc3=bookDataService.findByBookCollection3();
        List<BookData> bookDataListc4=bookDataService.findByBookCollection4();
        model.addAttribute("bookDatac1",bookDatac1);
        model.addAttribute("bookDataListc2",bookDataListc2);
        model.addAttribute("bookDataListc3",bookDataListc3);
        model.addAttribute("bookDataListc4",bookDataListc4);
        return "books/rank";
    }
    @RequestMapping("/detail")
    public String detail(@Param("id") Integer id, Model model, @Param("currentPage") Integer currentPage){
        PageBean pageBean=new PageBean();
        System.out.println("id======"+id);
        System.out.println("currentPage========="+currentPage);
        Chapter chapter=chapterService.findById(id);
        model.addAttribute("chapter",chapter);
        List<BookData> bookDataList=bookDataService.findAll(currentPage);
        System.out.println(bookDataList);
        pageBean.setTotalPage(bookDataList.size());
        if (currentPage==null||currentPage<=0){
            currentPage=1;
        }
        pageBean.setCurrentPage(currentPage);
        int pageNoLast=currentPage*10;
        if (pageNoLast>bookDataList.size()){
            pageNoLast=bookDataList.size();
        }
        List<BookData> bookData = bookDataList.subList((currentPage - 1) * 10, pageNoLast);
        int totalPage=bookDataList.size()%8==0?bookDataList.size()%8:bookDataList.size()+1;
        pageBean.setTotalPage(totalPage);
        model.addAttribute("bookDataList",bookDataList);
        model.addAttribute("bookData",bookData);
        model.addAttribute("pageBean",pageBean);
        return "books/rankdetail";
    }
    @RequestMapping("/detail1")
    public String detail1(Integer id,Model model){
        Chapter chapter=chapterService.findById(id);
        model.addAttribute("chapter",chapter);
        System.out.println(chapter);
        System.out.println("_________________");
        List<BookData> bookDataList1=bookDataService.findAll1();
        model.addAttribute("bookDataList1",bookDataList1);
        return "books/rankdetail1";
    }
}
