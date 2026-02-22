package com.capg.assessment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sales_employees")
public class SalesEmployee {

	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	    @SequenceGenerator(name = "emp_seq", sequenceName = "EMP_SEQ", allocationSize = 1)
	    private Long employeeId;

    private String name;
    private String department;

    // One SalesEmployee can have many Leads
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Lead> leads;

    // Default Constructor
    public SalesEmployee() {
    }

    // Parameterized Constructor
    public SalesEmployee(String name, String department) {
        this.name = name;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }
}