package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.BookData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDataDAO {
     //通过id查询某一个
     BookData findByBookId(Integer id);
     //查询所有(按月票查)
     List<BookData> findAll(Integer currentPage);
     //查询所有(按点击查)
     List<BookData> findAll1();
     //按总点赞数排序
     BookData findByBookClick1();
     //按总点赞数排序
     List<BookData> findByBookClick2();
     //按总点赞数排序
     List<BookData> findByBookClick3();
     //按总点赞数排序
     List<BookData> findByBookClick4();
     //按总字数排序
     BookData findByBookWords1();
     //按总字数排序
     List<BookData> findByBookWords2();
     //按总字数排序
     List<BookData> findByBookWords3();
     //按总字数排序
     List<BookData> findByBookWords4();
     //按总收藏数排序
     BookData findByBookCollection1();
     //按总收藏数排序
     List<BookData> findByBookCollection2();
     //按总收藏数排序
     List<BookData> findByBookCollection3();
     //按总收藏数排序
     List<BookData> findByBookCollection4();
     //按照月票数排序
     BookData findByBookTicket1();
     //按照月票数排序
     List<BookData> findByBookTicket2();
     //按照月票数排序
     List<BookData> findByBookTicket3();
     //按照月票数排序
     List<BookData> findByBookTicket4();
     //按照书的销售数排序1
     BookData findByBookSales1();
     //按照书的销售数排序2
     List<BookData> findByBookSales2();
     //按照书的销售数排序3
     List<BookData> findByBookSales3();
     //按照书的销售数排序4
     List<BookData> findByBookSales4();
     //按照书籍金额（每个章节金额的总和）排序
     List<BookData> findByBookMoney();
     //按照书籍订阅数排序
     BookData findByBookSubscribe1();
     //按照书籍订阅数排序
     List<BookData> findByBookSubscribe2();
     //按照书籍订阅数排序
     List<BookData> findByBookSubscribe3();
     //按照书籍订阅数排序
     List<BookData> findByBookSubscribe4();
     //修改数据
     void update(BookData bookData);
     //添加数据
     void add(BookData bookData);

     void delete(Integer id);
}
