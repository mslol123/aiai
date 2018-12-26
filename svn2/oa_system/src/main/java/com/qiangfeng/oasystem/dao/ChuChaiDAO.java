package com.qiangfeng.oasystem.dao;

import com.qiangfeng.oasystem.entity.ChuChai;
import org.activiti.engine.task.Task;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface ChuChaiDAO {
    void insert(ChuChai chuChai);
    List<ChuChai> findByUserId(Integer id);
    List<ChuChai> findByAllTask(List<Task> taskList);
    ChuChai findById(String id);
    void updateStatus(ChuChai chuChai);
}
