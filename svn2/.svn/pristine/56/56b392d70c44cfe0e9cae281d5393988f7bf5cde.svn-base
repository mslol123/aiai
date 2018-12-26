package com.qiangfeng.oasystem.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private SecurityManager securityManager;
    public void login(String username ,String password)throws Exception{
        Subject subject = SecurityUtils.getSubject();
        try {
            //创建一个用户名和密码登录的方式
            AuthenticationToken token = new UsernamePasswordToken(username, password);
            //尝试登录，真正是调用AuthsMySQLRealm来帮助登录
            subject.login(token);
            System.out.println("登录成功");
        }catch (UnknownAccountException eu){
            eu.printStackTrace();
            throw eu;
        }catch (IncorrectCredentialsException ei){
            ei.printStackTrace();
            throw ei;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

}
