package com.capg.assessment.entity;

import javax.persistence.*;

@Entity
@Table(name = "support_tickets")
public class SupportTicket {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "TICKET_SEQ", allocationSize = 1)
    private Long ticketId;

    private String issueDescription;

    // Many SupportTickets can belong to one Order
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Default Constructor
    public SupportTicket() {
    }

    // Parameterized Constructor
    public SupportTicket(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}