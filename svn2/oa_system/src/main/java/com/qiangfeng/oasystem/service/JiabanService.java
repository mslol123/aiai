package com.qiangfeng.oasystem.service;


import com.qiangfeng.oasystem.dao.JiabanDAO;
import com.qiangfeng.oasystem.dao.JiabanProcessDAO;
import com.qiangfeng.oasystem.dao.UserDAO;
import com.qiangfeng.oasystem.entity.Jiaban;
import com.qiangfeng.oasystem.entity.User;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class JiabanService {
    @Resource
    private JiabanDAO jiabanDAO;
    @Resource
    private JiabanProcessDAO jiabanProcessDAO;
    @Resource
    private UserDAO userDAO;

    public void save(Jiaban jiaban){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        jiaban.setId(id);
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 得到上级领导username
        String username = userDAO.findUsernameByTypeAndDept("leader", user.getDepartment().getId());
        String processId = jiabanProcessDAO.startJiabanProcessWithLeader(username);
        jiaban.setCreateDate(new Date());
        jiaban.setUser(user);
        jiaban.setProcessId(processId);
        jiaban.setJiabanStatus("待主管审批");
        jiabanDAO.insert(jiaban);
    }

    public List<Jiaban> findByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return jiabanDAO.findByUserId(user.getId());
    }

    public List<Jiaban> findTaskByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Task> taskList = jiabanProcessDAO.findTaskByCurrentUser(user.getUsername());
        if (taskList == null || taskList.size() == 0){
            return null;
        }
        return jiabanDAO.findByAllTask(taskList);
    }

    public Jiaban findById(String id){
        return jiabanDAO.findById(id);
    }

    public void jiabanCheck(boolean isCheck, Jiaban jiaban){
        jiabanProcessDAO.completeTask(isCheck, jiaban);
        jiabanDAO.updateStatus(jiaban);
    }
}