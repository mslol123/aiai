package com.qiangfeng.oasystem;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class YongCheTest {
    @Resource
    private ProcessEngine processEngine;
    @Test
    public void testDeployProcess(){
        processEngine.getRepositoryService().createDeployment()
                .addClasspathResource("bpmn/yongche.bpmn")
                .category("yc")
                .name("用车流程")
                .deploy();
    }
}
