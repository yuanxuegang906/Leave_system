package com.qf;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Calendar;

/*
 * author:袁学港
 * Date:2019/7/10 10:22
 * info:
 * */
public class ActivitiTest {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_dao.xml");
        RepositoryService repositoryService = (RepositoryService) applicationContext.getBean("repositoryService");
        repositoryService.createDeployment()
                .addClasspathResource("leave.bpmn").deploy();
    }

}
