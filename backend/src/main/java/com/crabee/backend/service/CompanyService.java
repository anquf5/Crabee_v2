package com.crabee.backend.service;

import com.crabee.backend.model.Company;
import com.crabee.backend.model.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompany(){
        return companyRepository.findAll();
    }

    public void addNewCompany(Company company) {
        Optional<Company> companyOptional = companyRepository
                .findCompanyByName(company.getName());
        if(companyOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        boolean exists = companyRepository.existsById(companyId);
        if(!exists){
            throw new IllegalStateException("company with id " + companyId + " does not exists");
        }
        companyRepository.deleteById(companyId);
    }

    @Transactional
    public void updateCompanyName(Long companyId,
                                  String name,
                                  String intro,
                                  String link) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new IllegalStateException("company with id " + companyId + " does not exist"));

        if (name != null
                && name.length() > 0
                && !Objects.equals(company.getName(), name)){
            company.setName(name);
        }

        
    }
}
