package com.jxky.bgxs.service.wx;

import com.jxky.bgxs.dao.ModeratorDAO;
import com.jxky.bgxs.entity.Moderator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ModeratorService {
    @Resource
    private ModeratorDAO moderatorDAO;

    public List<Moderator> findAllBookId(Integer id){
        return moderatorDAO.findAllBookId(id);
    }

    public void add(Moderator moderator){
        moderatorDAO.add(moderator);
    }

    public void delete(Integer id){moderatorDAO.delete(id);}
}

