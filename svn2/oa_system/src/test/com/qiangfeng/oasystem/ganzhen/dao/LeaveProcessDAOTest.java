package com.qiangfeng.oasystem.ganzhen.dao;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class LeaveProcessDAOTest {
    @Resource
    private ProcessEngine processEngine;

    @Test
    public void testDeployProcess(){
        processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("bpmn/leave.bpmn")
                .category("kq")
                .name("请假流程")
                .deploy();
    }

}