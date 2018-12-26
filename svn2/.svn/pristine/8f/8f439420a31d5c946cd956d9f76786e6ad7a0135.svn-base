package com.jxky.bgxs.service.xc;

import com.jxky.bgxs.dao.ConsumeDAO;
import com.jxky.bgxs.entity.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeService {
    @Autowired
    private ConsumeDAO consumeDAO;

    public List<Consume> findByUserId(Integer id){
        return consumeDAO.findByUserId(id);
    }
}
