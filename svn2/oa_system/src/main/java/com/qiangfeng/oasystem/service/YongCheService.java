package com.qiangfeng.oasystem.service;

import com.qiangfeng.oasystem.dao.UserDAO;
import com.qiangfeng.oasystem.entity.User;
import com.qiangfeng.oasystem.dao.YongCheDAO;
import com.qiangfeng.oasystem.dao.YongCheProcessDAO;
import com.qiangfeng.oasystem.entity.YongChe;
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
public class YongCheService {
    @Resource
    private UserDAO userDAO;
    @Resource
    private YongCheDAO yongCheDao;
    @Resource
    private YongCheProcessDAO yongCheProcessDao;
    public void save(YongChe yongChe){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        yongChe.setId(id);
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 得到上级领导username
        String username = userDAO.findUsernameByTypeAndDept("leader", user.getDepartment().getId());
        String processId = yongCheProcessDao.startLeaveProcessWithLeader(username);
        yongChe.setCreateDate(new Date());
        yongChe.setUser(user);
        yongChe.setProcessId(processId);
        yongChe.setStatus("待主管审批");
        yongCheDao.insert(yongChe);
    }

    public List<YongChe> findByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return yongCheDao.findByUserId(user.getId());
    }

    public List<YongChe> findTaskByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Task> taskList = yongCheProcessDao.findTaskByCurrentUser(user.getUsername());
        if (taskList == null || taskList.size() == 0){
            return null;
        }
        return yongCheDao.findByAllTask(taskList);
    }

    public YongChe findById(String id){
        return yongCheDao.findById(id);
    }

    public void yongCheCheck(boolean isCheck, YongChe yongChe){
        yongCheProcessDao.completeTask(isCheck, yongChe);
        yongCheDao.updateStatus(yongChe);
    }
}
