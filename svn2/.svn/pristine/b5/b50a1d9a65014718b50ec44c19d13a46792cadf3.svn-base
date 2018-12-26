package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDAO {
    Info findById(Integer id);
    void insert(Info info);
    void update(Info info);
    Info findLasterChapterByUserId(@Param("userId") Integer userId,@Param("bookId")Integer bookId);
}
