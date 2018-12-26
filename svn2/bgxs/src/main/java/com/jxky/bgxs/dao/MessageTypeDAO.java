package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.MessageType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageTypeDAO {
    List<MessageType> findAll();
    MessageType findById(int id);
}
