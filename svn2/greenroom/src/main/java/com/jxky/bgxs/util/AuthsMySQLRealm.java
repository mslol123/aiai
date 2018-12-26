package com.jxky.bgxs.util;

import com.jxky.bgxs.dao.AdminDAO;
import com.jxky.bgxs.dao.UserDAO;
import com.jxky.bgxs.entity.Admin;
import com.jxky.bgxs.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;

public class AuthsMySQLRealm extends AuthorizingRealm {
    @Resource
    private UserDAO userDAO;
    @Resource
    private AdminDAO adminDAO;

    @Override
    public String getName() {
        return "authsMySQLRealm";
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        Iterator iterator = principals.iterator();
//        if (iterator.hasNext()){
//            User user = (User) iterator.next();
//            List<String> codes = authService.findRoleCodeByUserId(user.getId());
//            if (codes != null && codes.size() > 0){
//                Set<String> codesSet = new HashSet<String>(codes);
//                Set<String> authsSet = new HashSet<String>();
//                for (String code : codes) {
//                    List<String> auths = authService.findAuthCodeByRoleCode(code);
//                    authsSet.addAll(auths);
//                }
//                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//                info.setRoles(codesSet);
//                info.setStringPermissions(authsSet);
//                return info;
//            }
//        }
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        if(username == null || password ==null || username.equals("") || password.equals("")){
            throw new AuthenticationException("username or password must be not null ");
        }
        Admin admin = adminDAO.findByusername(username);
        if(admin == null){
            throw new UnknownAccountException("user is null");
        }
        if(!admin.getPassword().equals(password)){
            throw new IncorrectCredentialsException("password is not right");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, admin.getPassword(), getName());
        return info;
    }
}