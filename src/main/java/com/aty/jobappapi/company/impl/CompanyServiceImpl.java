package com.aty.jobappapi.company.impl;

import com.aty.jobappapi.company.Company;
import com.aty.jobappapi.company.CompanyRepository;
import com.aty.jobappapi.company.CompanyService;
import com.aty.jobappapi.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {

            Company companyToUpdate = companyOptional.get();

            companyToUpdate.setName(updatedCompany.getName());
            companyToUpdate.setDescription(updatedCompany.getDescription());
            companyToUpdate.setJobs(updatedCompany.getJobs());

            companyRepository.save(companyToUpdate);

            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
