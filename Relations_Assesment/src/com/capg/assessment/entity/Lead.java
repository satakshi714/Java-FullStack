package com.capg.assessment.entity;

import javax.persistence.*;

@Entity
@Table(name = "leads")
public class Lead {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lead_seq")
    @SequenceGenerator(name = "lead_seq", sequenceName = "LEAD_SEQ", allocationSize = 1)
    private Long leadId;

    private String name;
    private String source;
    private String contactInfo;

    // Many Leads can be assigned to one SalesEmployee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private SalesEmployee employee;

    // Default Constructor
    public Lead() {
    }

    // Parameterized Constructor
    public Lead(String name, String source, String contactInfo) {
        this.name = name;
        this.source = source;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public SalesEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(SalesEmployee employee) {
        this.employee = employee;
    }
}