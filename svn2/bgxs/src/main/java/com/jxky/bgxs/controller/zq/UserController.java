package com.jxky.bgxs.controller.zq;

import com.jxky.bgxs.entity.*;
import com.jxky.bgxs.httpApiDemo.IndustrySMS;
import com.jxky.bgxs.service.wjt.BookShelfService;
import com.jxky.bgxs.service.wt.ChapterService;
import com.jxky.bgxs.service.wx.BookMessageService;
import com.jxky.bgxs.service.xc.AccountService;
import com.jxky.bgxs.service.xc.InfoService;
import com.jxky.bgxs.service.zq.UserService;
import com.jxky.bgxs.service.zsy.LatelyreadService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"account","user","info"})
public class UserController {
    private String safetyResult;
    @Autowired
    private UserService userService;

    @Resource
    private InfoService infoService;

    @Resource
    private AccountService accountService;
    @Resource
    private BookShelfService bookShelfService;
    @Resource
    private ChapterService chapterService;
    @Resource
    private LatelyreadService latelyreadService;
    @Resource
    private BookMessageService bookMessageService;


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

    @RequestMapping("/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "index";
    }

    @RequestMapping("amend")
    public String amend(Model model){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        User user1 = userService.findById(user.getId());
        model.addAttribute("u",user1);
        String tel=user1.getTel().substring(0,3)+"****"+user.getTel().substring(7,user.getTel().length());
        User user2 = new User();
        user2.setTel(tel);
        model.addAttribute("user",user2);
        return "/setting/amend";
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
        Info info = new Info();
        user.setNickname(nickname);
        user.setTel(tel);
        user.setPwd(pwd);
        user.setOnlynum(tel);
        userService.save(user);
        User user1 = userService.findByPhone(tel);
        info.setId(user1.getId());
        info.setNickname(nickname);
        infoService.insert(info);
        String only = userService.create();
        Account account = new Account();
        account.setUserId(user1.getId());
        account.setAccountId(only);
        accountService.insert(account);
        return "";
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

    @RequestMapping("judgephone1")
    @ResponseBody
    public Object judgephone1(String phone){
        User user = userService.findByPhone(phone);
        if(user != null){
            return user;
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

    @RequestMapping("preupdate")
    public String preupdate(){
        return "setting/userPass";
    }
    //普通修改密码，用户传过来旧密码，判断旧密码是否正确
    @RequestMapping("findByPwd")
    @ResponseBody
    public String findByPwd(String pwd){
        User user1 = (User)SecurityUtils.getSubject().getPrincipal();
        User user = userService.findByPwd(pwd,user1.getId());
        if(user != null){
            return "000";
        }
        return "123";
    }

    @RequestMapping("updatepwd")
    @ResponseBody
    public String updatepwd(String pwd){
        try {
            User user = (User)SecurityUtils.getSubject().getPrincipal();
            User user1 = new User();
            user1.setId(user.getId());
            user1.setPwd(pwd);
            userService.update(user1);
        } catch (Exception e) {
            e.printStackTrace();
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
        Account account = accountService.findByUserId(user.getId());
        Info info = infoService.findById(user.getId());
        model.addAttribute("info",info);
        model.addAttribute("account",account);
        return "index";
    }

    @RequestMapping("book")
    public String book(Model model){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        Account account = accountService.findByUserId(user.getId());
        Info info = infoService.findById(user.getId());
        //author：zsy  查询我的书架
        List<BookShelf> myBookShelfList = bookShelfService.findMyBookShelf(user.getId());
        //判断我的书架是否为空，非空则返回给页面用户的书架信息
        List<BookMessage> bookMessageList = new ArrayList<BookMessage>(); //初始化bookMessageList
        if(!myBookShelfList.isEmpty() || myBookShelfList.size()>0){
            //根据用户的书架里的书籍id，查询书籍的最后一章
            for (BookShelf bookShelf : myBookShelfList) {
                int bookId = bookShelf.getBookMessage().getBookId();
                List<Chapter> allChapterByBookId = chapterService.findAllChapterByBookId(bookId);
                Chapter chapter = allChapterByBookId.get(allChapterByBookId.size() - 1);
                //将最后一章信息添加到BookMessage中
                BookMessage bookMessage = bookShelf.getBookMessage();
                bookMessage.setChapter(chapter);
                bookMessageList.add(bookMessage);
            }
            model.addAttribute("bookMessageList",bookMessageList);
        }
        model.addAttribute("info",info);
        model.addAttribute("account",account);
        return "bookshelf/favoritesBook";
    }
    /**
     * author zsy
     * 个人账户信息里我的书架里 最近阅读
     * */
    @RequestMapping("/lastRead")
    public String lastRead(Integer userId,Model model){
        //根据用户id查询最近阅读的书籍信息
        List<LatelyRead> latelyReadList = latelyreadService.findAllByUserId(userId);
        List<BookMessage> lastReadList= new ArrayList<>();
        for (LatelyRead latelyRead : latelyReadList) {
            BookMessage message = bookMessageService.findById(latelyRead.getBookId());
            Chapter chapter = chapterService.findById(latelyRead.getChapterId());
            message.setChapter(chapter);
            lastReadList.add(message);
        }
        model.addAttribute("lastReadList",lastReadList);
        return "bookshelf/myBookReaded";
    }
}
