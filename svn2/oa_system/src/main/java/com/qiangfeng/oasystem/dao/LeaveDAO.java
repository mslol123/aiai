package com.qiangfeng.oasystem.dao;


import com.qiangfeng.oasystem.entity.Leave;
import org.activiti.engine.task.Task;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface LeaveDAO {
    void insert(Leave leave);
    List<Leave> findByUserId(Integer id);
    List<Leave> findByAllTask(List<Task> taskList);
    Leave findById(String id);
    void updateStatus(Leave leave);
}
