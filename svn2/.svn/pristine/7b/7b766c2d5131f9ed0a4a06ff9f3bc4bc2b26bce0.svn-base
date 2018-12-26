package com.jxky.bgxs.service.wjt;

import com.jxky.bgxs.dao.AccountDAO;
import com.jxky.bgxs.dao.BookDataDAO;
import com.jxky.bgxs.entity.Account;
import com.jxky.bgxs.entity.BookData;
import com.jxky.bgxs.entity.LoginResult;
import com.jxky.bgxs.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClickService {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private BookDataDAO bookDataDAO;
    public LoginResult addClick(int bookId,int num){
        LoginResult result = new LoginResult();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            result.setCode(2);
            result.setMsg("user is null");
            return result;
        }else {
            Account userAccount = accountDAO.findByUserId(user.getId());
            if(userAccount.getMonthticket()-num < 0){
                result.setCode(0);
                result.setMsg("Insufficient ticket");
                return result;
            }else {
                result.setCode(1);
                result.setMsg("Vote success");
                BookData bookData = bookDataDAO.findByBookId(bookId);
                bookData.setBookTicket(bookData.getBookTicket()+num);
                userAccount.setMonthticket(userAccount.getMonthticket()-num);
                accountDAO.update(userAccount);
                bookDataDAO.update(bookData);
                return result;
            }
        }
    }
}
