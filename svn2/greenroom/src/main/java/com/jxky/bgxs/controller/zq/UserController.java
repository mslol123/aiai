package com.jxky.bgxs.controller.zq;

import com.jxky.bgxs.entity.LoginResult;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.httpApiDemo.IndustrySMS;
import com.jxky.bgxs.service.zq.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    private String safetyResult;
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("log")
    public String log(){
        return "/user/login";
    }
    @RequestMapping("preadd")
    public String preadd(){
        return "/user/register";
    }
    @RequestMapping("dxyz")
    @ResponseBody
    public String dxyz(String phone){
        safetyResult = IndustrySMS.execute(phone);
        return safetyResult;
    }
    @RequestMapping("save")
    @ResponseBody
    public String save(String nickname,String pwd,String tel){
        User user = new User();
        user.setNickname(nickname);
        user.setTel(tel);
        user.setPwd(pwd);
        user.setOnlynum(tel);
        userService.save(user);
        return "123456";
    }
    @RequestMapping("judgephone")
    @ResponseBody
    public String judgephone(String phone){
        User userTel = userService.findByTel(phone);
        if(userTel != null){
            return "此号码已注册过";
        }
        return "000";
    }
    @RequestMapping("judgeName")
    @ResponseBody
    public String judgeName(String nickname){
        User name = userService.findByName(nickname);
        if(name != null){
            return "此昵称已存在";
        }
        return "000";
    }
    @RequestMapping("login")
    @ResponseBody
    public Object login(String tel, String pwd){
        LoginResult loginResult = new LoginResult();
        try {
            userService.login(tel, pwd);
            loginResult.setCode(0);
        }catch (UnknownAccountException u){
            u.printStackTrace();
            loginResult.setCode(001);
            loginResult.setMsg("用户不存在");
        }catch (IncorrectCredentialsException i){
            i.printStackTrace();
            loginResult.setCode(002);
            loginResult.setMsg("密码错误");
        }catch (AuthenticationException a){
            a.printStackTrace();
            loginResult.setCode(003);
            loginResult.setMsg("用户名和密码不能为空");
        }catch (Exception e){
            e.printStackTrace();
            loginResult.setCode(004);
            loginResult.setMsg("未知异常，请联系管理员");
        }
        return loginResult;
    }

    @RequestMapping("/loginin")
    public String loginin(Model model) {
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user",user);
        return "index";
    }
    @RequestMapping("book")
    public String book(){
        return "bookshelf/favoritesBook";
    }
}
