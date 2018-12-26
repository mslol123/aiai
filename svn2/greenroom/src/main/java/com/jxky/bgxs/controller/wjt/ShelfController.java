package com.jxky.bgxs.controller.wjt;

import com.jxky.bgxs.entity.LoginResult;
import com.jxky.bgxs.entity.User;
import com.jxky.bgxs.service.wjt.BookShelfService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    private BookShelfService bookShelfService;
    @RequestMapping("/addShelf")
    @ResponseBody
    public LoginResult addShelf(String id){
        LoginResult result = new LoginResult();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            result.setCode(2);
            result.setMsg("请先登录用户");
        }else {
            try {
                int bookId = Integer.parseInt(id);
                bookShelfService.addShelf(bookId,user.getId());
                result.setCode(0);
                result.setMsg("添加成功");
            }catch (Exception e){
                result.setCode(1);
                result.setMsg("书籍已经添加过");
            }
        }
        return result;
    }
}
