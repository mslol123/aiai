package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Chapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ChapterDAO {
    List<Chapter> findAllChapter();
    List<Chapter> findChapterByBookId(Integer id);
    void insert(Chapter chapter);
    Chapter findById(Integer id);
    void update(Chapter chapter);
    void delete(Integer id);
    List<Chapter> findChapterByDate(@Param("id")Integer id,@Param("date")Date date);
    Integer findCountByDate(@Param("id")Integer id,@Param("date")Date date);
    List<Chapter> findChapterByStatus(String chapterStatus);
    void deleteChapterStatus(Integer id);
    List<Chapter> findLastByDate(@Param("id")Integer id,@Param("date1")Date date1,@Param("date2")Date date2);
    Integer findCountByBookId(Integer id);
}
