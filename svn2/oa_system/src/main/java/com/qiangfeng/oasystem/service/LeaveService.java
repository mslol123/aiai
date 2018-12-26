package com.qiangfeng.oasystem.service;


import com.qiangfeng.oasystem.dao.LeaveDAO;
import com.qiangfeng.oasystem.dao.LeaveProcessDAO;
import com.qiangfeng.oasystem.dao.UserDAO;
import com.qiangfeng.oasystem.entity.Leave;
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
public class LeaveService {
    @Resource
    private LeaveDAO leaveDAO;
    @Resource
    private LeaveProcessDAO leaveProcessDAO;
    @Resource
    private UserDAO userDAO;

    public void save(Leave leave){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        leave.setId(id);
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 得到上级领导username
        String username = userDAO.findUsernameByTypeAndDept("leader", user.getDepartment().getId());
        String processId = leaveProcessDAO.startLeaveProcessWithLeader(username);
        leave.setCreateDate(new Date());
        leave.setUser(user);
        leave.setProcessId(processId);
        leave.setLeaveStatus("待主管审批");
        leaveDAO.insert(leave);
    }

    public List<Leave> findByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return leaveDAO.findByUserId(user.getId());
    }

    public List<Leave> findTaskByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Task> taskList = leaveProcessDAO.findTaskByCurrentUser(user.getUsername());
        if (taskList == null || taskList.size() == 0){
            return null;
        }
        return leaveDAO.findByAllTask(taskList);
    }

    public Leave findById(String id){
        return leaveDAO.findById(id);
    }

    public void leaveCheck(boolean isCheck, Leave leave){
        leaveProcessDAO.completeTask(isCheck, leave);
        leaveDAO.updateStatus(leave);
    }
}