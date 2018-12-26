package com.qiangfeng.oasystem.dao;


import com.qiangfeng.oasystem.entity.User;
import com.qiangfeng.oasystem.entity.ChuChai;
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
public class ChuChaiProcessDAO {
   @Resource
   private ProcessEngine processEngine;
   @Resource
   private UserDAO userDAO;
   public String startLeaveProcessWithLeader(String username) {
        Map map = new HashMap();
        map.put("leader", username);
        //获得流程执行服务类
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //获得流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("chuchai", map);
        return processInstance.getId();
    }

    public List<Task> findTaskByCurrentUser(String username){
        return processEngine.getTaskService().createTaskQuery()
                .taskCandidateOrAssigned(username).list();
    }

    public void completeTask(boolean isCheck, ChuChai chuChai){
        //通过出差流程id获得任务
        Task task = processEngine.getTaskService().createTaskQuery()
                .processInstanceId(chuChai.getProcessId())
                .singleResult();
        String taskDefinitionKey = task.getTaskDefinitionKey();
        // 主管流程
        if (taskDefinitionKey.equals("leader_check")){
            Map map = new HashMap();
            if (isCheck){
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                // 得到上级领导username
                String username = userDAO.findUsernameByTypeAndDept("manager", user.getDepartment().getId());
                map.put("is_leader_checked", 1);
                map.put("manager", username);
                chuChai.setStatus("待经理审核");
            }else{
                map.put("is_leader_checked", 2);
                chuChai.setStatus("主管未通过");
            }
            //完成任务
            processEngine.getTaskService().complete(task.getId(), map);

            // 经理流程
        }else if (taskDefinitionKey.equals("manager_check")){
            if (isCheck){
                chuChai.setStatus("审核已完成");
            }else{
                chuChai.setStatus("经理未通过");
            }
            processEngine.getTaskService().complete(task.getId());
        }
    }

}
