package com.jxky.bgxs.service.xc;

import com.jxky.bgxs.dao.AccountDAO;
import com.jxky.bgxs.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService {

    @Resource
    private AccountDAO accountDAO;

    public Account findByUserId(Integer id){
        return accountDAO.findByUserId(id);
    }
}
