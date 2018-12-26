package com.qiangfeng.oasystem;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ChuChaiTest {
    @Resource
    private ProcessEngine processEngine;
    @Test
    public void testDeployProcess(){
        processEngine.getRepositoryService().createDeployment()
                .addClasspathResource("bpmn/chuchai.bpmn")
                .category("cc")
                .name("出差流程")
                .deploy();
    }
}
