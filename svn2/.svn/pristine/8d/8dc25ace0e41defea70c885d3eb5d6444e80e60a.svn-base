package com.qiangfeng.oasystem.util;


import com.qiangfeng.oasystem.entity.User;
import com.qiangfeng.oasystem.service.AuthService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class AuthsMySQLRealm extends AuthorizingRealm {
    @Resource
    private AuthService authService;

    @Override
    public String getName() {
        return "authsMySQLRealm";
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String number = upToken.getUsername();
        String pwd = new String(upToken.getPassword());
        User user = authService.findUserByUsernameAndPwd(number, pwd);
        if (user != null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            return info;
        }
        return null;
    }
}