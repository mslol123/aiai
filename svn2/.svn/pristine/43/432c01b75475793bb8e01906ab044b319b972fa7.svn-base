package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.LatelyRead;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LatelyReadDAO {
    void firstRead(@Param("userId")Integer userId,@Param("chapterId")Integer chapterId,@Param("bookId")Integer bookId);
    void updateRead(@Param("userId")Integer userId,@Param("chapterId")Integer chapterId,@Param("bookId")Integer bookId);
    LatelyRead findByUserIdAndBookId(@Param("userId")Integer userId,@Param("bookId")Integer bookId);
    List<LatelyRead> findAllByUserId(Integer userId);
}
