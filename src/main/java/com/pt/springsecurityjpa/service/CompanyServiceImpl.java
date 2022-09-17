package com.pt.springsecurityjpa.service;

import com.pt.springsecurityjpa.model.Company;
import com.pt.springsecurityjpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    @Override
    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }
    @Override
    public Company getCompanyById(long id) {
        Optional<Company> optional = companyRepository.findById(id);
        Company company = null;
        if (optional.isPresent()) {
            company = optional.get();
        } else {
            throw new RuntimeException("Company not foud for id :: " + id);
        }
        return company;
    }
    @Override
    public void deleteCompanyById(long id) {
        this.companyRepository.deleteById(id);
    }
}