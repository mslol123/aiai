package com.qiangfeng.oasystem.dao;


import com.qiangfeng.oasystem.entity.Jiaban;
import com.qiangfeng.oasystem.entity.User;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JiabanProcessDAO {
    @Resource
    private ProcessEngine processEngine;
    @Resource
    private UserDAO userDAO;

    public String startJiabanProcessWithLeader(String username) {
        Map map = new HashMap();
        map.put("leader", username);
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("jiaban", map);
        return processInstance.getId();
    }

    public List<Task> findTaskByCurrentUser(String username){
        return processEngine.getTaskService().createTaskQuery()
                .taskCandidateOrAssigned(username).list();
    }

    public void completeTask(boolean isCheck, Jiaban jiaban){
        Task task = processEngine.getTaskService().createTaskQuery()
                .processInstanceId(jiaban.getProcessId())
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
                jiaban.setJiabanStatus("待经理审核");
            }else{
                map.put("is_leader_Checked", 2);
                jiaban.setJiabanStatus("主管未通过");
            }
            processEngine.getTaskService().complete(task.getId(), map);

            // 经理流程
        }else if (taskDefinitionKey.equals("manager_check")){
            if (isCheck){
                jiaban.setJiabanStatus("审核已完成");
            }else{
                jiaban.setJiabanStatus("经理未通过");
            }
            processEngine.getTaskService().complete(task.getId());
        }
    }
}
