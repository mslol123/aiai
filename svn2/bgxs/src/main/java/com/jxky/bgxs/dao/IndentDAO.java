package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Indent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndentDAO {
    void insert(Indent indent);
    List<Indent> findByUserId(Integer id);
    void updateState(Indent indent);
}
