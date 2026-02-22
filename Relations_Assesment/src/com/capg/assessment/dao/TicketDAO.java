package com.capg.assessment.dao;

import com.capg.assessment.entity.SupportTicket;

public interface TicketDAO {

    void save(SupportTicket ticket);

    SupportTicket findById(Long id);

    void delete(SupportTicket ticket);
}