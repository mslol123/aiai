package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.BookData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDataDAO {
     //通过id查询某一个
     BookData findByBookId(Integer id);
     //查询所有
     List<BookData> findAll();
     //按总点赞数排序
     List<BookData> findByBookClick();
     //按总字数排序
     List<BookData> findByBookWords();
     //按总收藏数排序
     List<BookData> findByBookCollection();
     //按照月票数排序
     List<BookData> finByBookTicket();
     //按照书的销售数排序
     List<BookData> findByBookSales();
     //按照书籍金额（每个章节金额的总和）排序
     List<BookData> findByBookMoney();
     //按照书籍订阅数排序
     List<BookData> findByBookSubscribe();

}
