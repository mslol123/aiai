package com.jxky.bgxs.service.zq;

import com.jxky.bgxs.dao.IndentDAO;
import com.jxky.bgxs.entity.Indent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class IndentService {
    @Resource
    private IndentDAO indentDAO;

    public void insert(Indent indent){
        indentDAO.insert(indent);
    }

    public List<Indent> findByUserId(Integer id) {
        return indentDAO.findByUserId(id);
    }

    public void updateState(Indent indent){
        indentDAO.updateState(indent);
    }

}
