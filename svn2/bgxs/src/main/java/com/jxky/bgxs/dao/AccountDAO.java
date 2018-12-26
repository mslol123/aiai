package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO {
    Account findByUserId(Integer userId);

    void insert(Account account);

    void update(Account account);

}
