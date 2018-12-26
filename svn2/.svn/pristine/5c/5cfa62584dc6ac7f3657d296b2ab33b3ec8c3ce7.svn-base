package com.qiangfeng.oasystem.ganzhen.dao;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JiabanProcessDAOTest {
    @Resource
    private ProcessEngine processEngine;

    @Test
    public void testDeployProcess(){
        processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("bpmn/jiaban.bpmn")
                .category("kq")
                .name("加班流程")
                .deploy();
    }

    /**
     * 删除部署信息
     */
    @Test
    public void deleteDeployment(){
        String deploymentId="2501";
        processEngine.getRepositoryService().deleteDeployment(deploymentId,true);
    }
}