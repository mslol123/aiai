package com.qiangfeng.oasystem.dao;

import com.qiangfeng.oasystem.entity.Jiaban;
import org.activiti.engine.task.Task;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface JiabanDAO {
    void insert(Jiaban jiaban);
    List<Jiaban> findByUserId(Integer id);
    List<Jiaban> findByAllTask(List<Task> taskList);
    Jiaban findById(String id);
    void updateStatus(Jiaban jiaban);
}
