package com.qiangfeng.oasystem.service;


import com.qiangfeng.oasystem.dao.UserDAO;
import com.qiangfeng.oasystem.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthService {
    @Resource
    private UserDAO userDAO;
    public User findUserByUsernameAndPwd(String username, String password){
        return userDAO.findUserByUsernameAndPwd(username, password);
    }

    public List<String> findRoleCodeByUserId(Integer id){
        return userDAO.findRoleCodeByUserId(id);
    }

}
