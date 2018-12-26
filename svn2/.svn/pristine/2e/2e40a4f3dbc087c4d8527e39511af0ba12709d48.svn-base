package com.jxky.bgxs.service.xc;


import com.jxky.bgxs.dao.TicketDAO;
import com.jxky.bgxs.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    public List<Ticket> findByUserId(Integer userId){
        return ticketDAO.findByUserId(userId);
    }

    private void insert(Ticket ticket){
        ticketDAO.insert(ticket);
    }
}
