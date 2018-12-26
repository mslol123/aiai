package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Moderator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeratorDAO {
    List<Moderator> findAllByAuthorId(Integer id);

}
