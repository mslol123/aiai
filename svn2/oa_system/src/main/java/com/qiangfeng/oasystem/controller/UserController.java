package com.qiangfeng.oasystem.controller;

import com.qiangfeng.oasystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/*
spring整合shiro自定义数据库的步骤：
1. 导入包，除了之前ssm框架所需要包以外，还需要导入shiro-core,shiro-web,shiro-spring,common-logging
2. 在web。xml中添加shiro的过滤器
3. 在spring-mvc.xml中添加对shiro注解的支持
4. 在spring.xml中添加对shiro的支持
5. 添加自定义的realm去实现两个方法
 */

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        try {
            userService.login(username, password);
        } catch (Exception e) {
            model.addAttribute("msg", "用户名或密码错误");
            return "/index";
        }
        return "home";
    }
}