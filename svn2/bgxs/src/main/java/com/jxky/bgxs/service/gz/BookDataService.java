package com.jxky.bgxs.service.gz;

import com.jxky.bgxs.dao.BookDataDAO;
import com.jxky.bgxs.entity.BookData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookDataService {
    @Autowired
    private BookDataDAO bookDataDAO;
    @Resource
    private RedisTemplate redisTemplate;
    //通过id查询某一个
    public BookData findByBookId(Integer id) {
        //查缓存
        BookData bookData = (BookData)redisTemplate.opsForValue().get("book_" + String.valueOf(id));
        if(bookData != null){
            return bookData;
        }else {
            //缓存没有，存入缓存
            redisTemplate.opsForValue().set("book_",bookData);
            return bookDataDAO.findByBookId(id);
        }
    }
    //分页查询所有（按月票）
    public List<BookData> findAll(Integer currentPage){
//        BoundListOperations<String, String> listOperations = redisTemplate.boundListOps("bookDataList");
//        Long size = listOperations.size();
//        //查缓存
//        List<String> bookDataList = redisTemplate.boundListOps("bookDataList").range(0,size);
//        if(bookDataList!=null){
//            return bookDataList;
//        }
        return bookDataDAO.findAll(currentPage);
    }
    //查询所有（按点击）
    public List<BookData> findAll1(){ return bookDataDAO.findAll1();}
    //按总点赞数排序
    public BookData findByBookClick1(){
        return bookDataDAO.findByBookClick1();
    }
    //按总点赞数排序
    public List<BookData> findByBookClick2(){
        return bookDataDAO.findByBookClick2();
    }
    //按总点赞数排序
    public List<BookData> findByBookClick3(){
        return bookDataDAO.findByBookClick3();
    }
    //按总点赞数排序
    public List<BookData> findByBookClick4(){
        return bookDataDAO.findByBookClick4();
    }
    //按总字数排序
    public BookData findByBookWords1(){
        return bookDataDAO.findByBookWords1();
    }
    //按总字数排序
    public List<BookData> findByBookWords2(){
        return bookDataDAO.findByBookWords2();
    }
    //按总字数排序
    public List<BookData> findByBookWords3(){
        return bookDataDAO.findByBookWords3();
    }
    //按总字数排序
    public List<BookData> findByBookWords4(){
        return bookDataDAO.findByBookWords4();
    }
    //按总收藏数排序
    public BookData findByBookCollection1(){
        return bookDataDAO.findByBookCollection1();
    }
    //按总收藏数排序
    public List<BookData> findByBookCollection2(){
        return bookDataDAO.findByBookCollection2();
    }
    //按总收藏数排序
    public List<BookData> findByBookCollection3(){
        return bookDataDAO.findByBookCollection3();
    }
    //按总收藏数排序
    public List<BookData> findByBookCollection4(){
        return bookDataDAO.findByBookCollection4();
    }
    //按照月票数排序1
    public BookData findByBookTicket1(){ return bookDataDAO.findByBookTicket1(); }
    //按照月票数排序2
    public List<BookData> findByBookTicket2(){  return bookDataDAO.findByBookTicket2(); }
    //按照月票数排序3
    public List<BookData> findByBookTicket3(){
        return bookDataDAO.findByBookTicket3();
    }
    //按照月票数排序4
    public List<BookData> findByBookTicket4(){
        return bookDataDAO.findByBookTicket4();
    }
    //按照书的销售数排序
    public BookData findByBookSales1(){
        return bookDataDAO.findByBookSales1();
    }
    //按照书的销售数排序
    public List<BookData> findByBookSales2(){
        return bookDataDAO.findByBookSales2();
    }
    //按照书的销售数排序
    public List<BookData> findByBookSales3(){
        return bookDataDAO.findByBookSales3();
    }
    //按照书的销售数排序
    public List<BookData> findByBookSales4(){
        return bookDataDAO.findByBookSales4();
    }
    //按照书籍金额（每个章节金额的总和）排序
    public List<BookData> findByBookMoney(){
        return bookDataDAO.findByBookMoney();
    }
    //按照书籍订阅数排序
    public BookData findByBookSubscribe1(){
        return bookDataDAO.findByBookSubscribe1();
    }
    //按照书籍订阅数排序
    public List<BookData> findByBookSubscribe2(){
        return bookDataDAO.findByBookSubscribe2();
    }
    //按照书籍订阅数排序
    public List<BookData> findByBookSubscribe3(){
        return bookDataDAO.findByBookSubscribe3();
    }
    //按照书籍订阅数排序
    public List<BookData> findByBookSubscribe4(){
        return bookDataDAO.findByBookSubscribe4();
    }

    public void add(BookData bookData){bookDataDAO.add(bookData);}

    public void delete(Integer id){bookDataDAO.delete(id);}
}