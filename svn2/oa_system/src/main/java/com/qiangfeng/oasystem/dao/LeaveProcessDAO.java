package com.qiangfeng.oasystem.dao;


import com.qiangfeng.oasystem.entity.User;
import com.qiangfeng.oasystem.entity.Leave;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LeaveProcessDAO {
    @Resource
    private ProcessEngine processEngine;
    @Resource
    private UserDAO userDAO;

    public String startLeaveProcessWithLeader(String username) {
        Map map = new HashMap();
        map.put("leader", username);
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", map);
        return processInstance.getId();
    }

    public List<Task> findTaskByCurrentUser(String username){
        return processEngine.getTaskService().createTaskQuery()
                .taskCandidateOrAssigned(username).list();
    }

    public void completeTask(boolean isCheck, Leave leave){
        Task task = processEngine.getTaskService().createTaskQuery()
                .processInstanceId(leave.getProcessId())
                .singleResult();
        String taskDefinitionKey = task.getTaskDefinitionKey();
        // 主管流程
        if (taskDefinitionKey.equals("leader_check")){
            Map map = new HashMap();
            if (isCheck){
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                // 得到上级领导username
                String username = userDAO.findUsernameByTypeAndDept("manager", user.getDepartment().getId());
                map.put("is_leader_Checked", 1);
                map.put("manager", username);
                leave.setLeaveStatus("待经理审核");
            }else{
                map.put("is_leader_Checked", 2);
                leave.setLeaveStatus("主管未通过");
            }
            processEngine.getTaskService().complete(task.getId(), map);

            // 经理流程
        }else if (taskDefinitionKey.equals("manager_check")){
            if (isCheck){
                leave.setLeaveStatus("审核已完成");
            }else{
                leave.setLeaveStatus("经理未通过");
            }
            processEngine.getTaskService().complete(task.getId());
        }
    }
}