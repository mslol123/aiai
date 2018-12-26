package com.jxky.bgxs.service.zq;

import com.jxky.bgxs.dao.IndentDAO;
import com.jxky.bgxs.dao.UserDAO;
import com.jxky.bgxs.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

@Service
@Transactional
public class UserService {
    @Resource
    private UserDAO userDAO;

    @Resource
    private IndentDAO indentDAO;

    public void login(String tel,String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token =  new UsernamePasswordToken(tel,pwd);
        subject.login(token);
    }
    public User findByTel(String tel){
        return userDAO.findBytel(tel);
    }
    public void save(User user){
        userDAO.save(user);
    }
    public User findByName(String name){
        return userDAO.findByName(name);
    }
    public void update(User user){
        userDAO.update(user);
    }
    public User findByPhone(String phone){
        return userDAO.findByTel(phone);
    }
    public User findByNickname(String nickname){
        return userDAO.findByNickname(nickname);
    }

    public User findByPwd(String pwd,Integer id){
        return userDAO.findByPwd(id,pwd);
    }
    public User findById(Integer id){
        return userDAO.findById(id);
    }

    /**
     *
     * @return 生成的唯一账户
     */
    public String create(){
        String num="";
        String str="abcdefghijklmnopqrstuvwxyz";
        String str1 = "";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<3; i++){
            //产生0-24的数字
            int number=random.nextInt(23);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        for (int i=0;i<8;i++) {
            num += random.nextInt(10);
        }
        String sn = sb+num;
        return sn;
    }
}
