package com.jxky.bgxs.service.gzx;

import com.jxky.bgxs.dao.AdminDAO;
import com.jxky.bgxs.dao.BookMessageDAO;
import com.jxky.bgxs.entity.Admin;
import com.jxky.bgxs.entity.BookMessage;
import com.jxky.bgxs.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdminService {
    @Resource
    private AdminDAO adminDAO;

    public void login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token =  new UsernamePasswordToken(username,password);
        subject.login(token);
    }

    public Admin findByusername(String username){
        return adminDAO.findByusername(username);
    }

    public void updatelogtime(Admin admin){
        adminDAO.updatelogtime(admin);
    }

    public void updatepwd(Admin admin){
        adminDAO.updatepwd(admin);
    }

}
