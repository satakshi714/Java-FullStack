package com.capg.assessment.service;

import com.capg.assessment.entity.Lead;

public interface LeadService {

    // Create a new Lead
    void createLead(String name, String source, String contactInfo);

    // Assign a Lead to a SalesEmployee
    void assignLeadToEmployee(Long leadId, Long employeeId);

    // Convert Lead into Customer
    void convertLeadToCustomer(Long leadId);

    // Find Lead by Id
    Lead getLeadById(Long leadId);
}