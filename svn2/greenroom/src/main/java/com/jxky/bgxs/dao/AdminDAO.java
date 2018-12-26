package com.jxky.bgxs.dao;


import com.jxky.bgxs.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AdminDAO {
    Admin findByusername(String username);
    void updatelogtime(Admin admin);
    void updatepwd(Admin admin);
}
