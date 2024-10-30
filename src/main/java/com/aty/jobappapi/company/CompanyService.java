package com.aty.jobappapi.company;

import com.aty.jobappapi.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();



    boolean updateCompany(Company company, Long id);

    void createCompzny(Company company);


}
