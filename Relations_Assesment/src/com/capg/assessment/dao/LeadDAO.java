package com.capg.assessment.dao;

import com.capg.assessment.entity.Lead;

public interface LeadDAO {

    void save(Lead lead);

    Lead findById(Long id);

    void update(Lead lead);

    void delete(Lead lead);
}