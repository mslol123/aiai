package com.qiangfeng.oasystem.dao;

import com.qiangfeng.oasystem.entity.YongChe;
import org.activiti.engine.task.Task;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
@MapperScan
@Repository
public interface YongCheDAO {
    void insert(YongChe yongChe);
    List<YongChe> findByUserId(Integer id);
    List<YongChe> findByAllTask(List<Task> taskList);
    YongChe findById(String id);
    void updateStatus(YongChe yongChe);
}
