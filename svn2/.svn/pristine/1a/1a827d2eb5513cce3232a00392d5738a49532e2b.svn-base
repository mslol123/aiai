package com.qiangfeng.oasystem.service;

import com.qiangfeng.oasystem.dao.UserDAO;
import com.qiangfeng.oasystem.entity.User;
import com.qiangfeng.oasystem.dao.ChuChaiDAO;
import com.qiangfeng.oasystem.dao.ChuChaiProcessDAO;

import com.qiangfeng.oasystem.entity.ChuChai;
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
public class ChuChaiService {
    @Resource
    private UserDAO userDAO;
    @Resource
    private ChuChaiDAO chuChaiDao;
    @Resource
    private ChuChaiProcessDAO chuChaiProcessDao;
    public void save(ChuChai chuChai){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        chuChai.setId(id);
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 得到上级领导username
        String username = userDAO.findUsernameByTypeAndDept("leader", user.getDepartment().getId());
        String processId = chuChaiProcessDao.startLeaveProcessWithLeader(username);
        chuChai.setCreateDate(new Date());
        chuChai.setUser(user);
        chuChai.setProcessId(processId);
        chuChai.setStatus("待主管审批");
        chuChaiDao.insert(chuChai);
    }

    public List<ChuChai> findByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return chuChaiDao.findByUserId(user.getId());
    }

    public List<ChuChai> findTaskByCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Task> taskList = chuChaiProcessDao.findTaskByCurrentUser(user.getUsername());
        if (taskList == null || taskList.size() == 0){
            return null;
        }
        return chuChaiDao.findByAllTask(taskList);
    }

    public ChuChai findById(String id){
        return chuChaiDao.findById(id);
    }

    public void chuChaiCheck(boolean isCheck, ChuChai chuChai){
        chuChaiProcessDao.completeTask(isCheck, chuChai);
        chuChaiDao.updateStatus(chuChai);
    }
}
