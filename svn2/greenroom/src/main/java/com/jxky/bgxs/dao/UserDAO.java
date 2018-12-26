package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO {
    User findByNP(@Param("tel") String tel);
    User findById(int id);
    User findBytel(String tel);
    void save(User user);
    User findByName(String name);
    void update(User user);
}