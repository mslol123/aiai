package com.qiangfeng.oasystem.dao;


import com.qiangfeng.oasystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@MapperScan
@Repository
public interface UserDAO {
     User findUserByUsernameAndPwd(@Param("username") String username,
                                   @Param("password") String password);
     List<String> findRoleCodeByUserId(Integer id);

     String findUsernameByTypeAndDept(@Param("type") String type, @Param("deptId") Integer deptId);
}
