package com.capg.assessment.service;

import com.capg.assessment.entity.SupportTicket;

public interface TicketService {

    // Raise a support ticket for an order
    void raiseTicket(Long orderId, String issueDescription);

    // Find ticket by Id
    SupportTicket getTicketById(Long ticketId);

    // Delete ticket
    void deleteTicket(Long ticketId);
}