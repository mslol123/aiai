package com.jxky.bgxs.dao;

import com.jxky.bgxs.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO {
    void insert(Message message);
    List<Message> findBySendUserId(int id);
    List<Message> findByAcceptUserId(int id);
}
